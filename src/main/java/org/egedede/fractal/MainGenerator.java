package org.egedede.fractal;

import org.egedede.fractal.model.Point;
import org.egedede.fractal.model.Window;
import org.egedede.fractal.service.EuclidianEvaluator;
import org.egedede.fractal.service.MandelbrotFormula;
import org.egedede.fractal.service.PointGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.GZIPOutputStream;

public class MainGenerator {
    public static void main(String[] args) throws Exception {
        Window window = Window.fromXYWidthHeight(-2d, -2d, 4d, 4d);
        EuclidianEvaluator evaluator = new EuclidianEvaluator();
        for (int i = 4; i < 5; i++) {
            File file = new File("./src/main/resources/models/model_" + i + ".data.gz");
            long estimation = (long) (16 * Math.pow(10, i * 2));
            file.getParentFile().mkdirs();
            try (PrintWriter fileWriter = new PrintWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file))))) {
                fileWriter.println(List.of(-2, -2, 4, 4).stream().map(Object::toString).collect(Collectors.joining(",")));
                fileWriter.println((4 * Math.pow(10, i)+1) + "," + (4 * Math.pow(10, i)+1));
                PointGenerator generator = new PointGenerator(window, i);
                int cpt = 0;
                while (generator.hasNext()) {
                    cpt++;
                    Point point = generator.next();
                    BigDecimal x = point.x;
                    BigDecimal y = point.y;
                    System.out.print(LocalDateTime.now() + " " + file.getName() + " " + point + " " + cpt + "/" + estimation + " : ");
                    int iteration = 0;
                    if (isShortcut(point)) {
                        iteration = 767;
                        System.out.println("shortcut");
                    } else {
                        MandelbrotFormula formula = new MandelbrotFormula(point);
                        while (iteration < 767 && evaluator.evaluate(point).compareTo(new BigDecimal("2.0")) < 0) {
                            point = formula.next(point);
                            iteration++;
                        }
                        System.out.println(iteration);
                    }
                    fileWriter.println(x.toPlainString() + "," + y.toPlainString() + "," + iteration);
                }
            }
        }
    }

    private static boolean isShortcut(Point point) {
        if (point.x.add(BigDecimal.ONE).pow(2).add(point.y.pow(2)).compareTo(new BigDecimal("0.0625")) < 0) {
            return true;
        }
        BigDecimal p = point.x.add(new BigDecimal("0.25").negate()).pow(2).add(point.y.pow(2)).sqrt(MathContext.DECIMAL128);
        if (point.x.compareTo(p.add(new BigDecimal("2").multiply(p.pow(2)).negate()).add(new BigDecimal("0.25"))) < 0) {
            return true;
        }
        return false;
    }
}

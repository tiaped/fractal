package org.egedede.fractal.swing;

import org.egedede.fractal.model.ColorIterationModel;
import org.egedede.fractal.model.IterationModel;
import org.egedede.fractal.model.Point;
import org.egedede.fractal.model.PointValued;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.zip.GZIPInputStream;

public class FractalFrame extends JFrame {

    public FractalFrame(File content, IterationModel iterationModel) throws Exception{
        super("Fractal");
        PointValued[][] data = readContent(content);

        FractalPane fractalPane = new FractalPane(data, 0, 0, iterationModel);
        this.setContentPane(fractalPane);
        this.setSize(30, 30);
        this.setVisible(true);
    }

    private PointValued[][] readContent(File content) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(content))));
        reader.readLine(); // bluff
        String[] dimensions = reader.readLine().split(",");
        final int width = (int) (Double.parseDouble(dimensions[0])+1);
        final int height = (int) (Double.parseDouble(dimensions[1])+1);
        PointValued[][] result = new PointValued[width][height];
        for(int i = 0;i<width;i++ ){
            for(int j=0;j<height;j++){
                result[i][j] = readLine(reader.readLine());
            }
        }
        return result;
    }

    private PointValued readLine(String line) {
        final String[] split = line.split(",");
        return new PointValued(new Point(new BigDecimal(split[0]),new BigDecimal(split[1])), Integer.parseInt(split[2]));
    }


    public static void main(String[] args) throws Exception{
        new FractalFrame(new File("./src/main/resources/models/model_2.data.gz"), new ColorIterationModel(767));
    }
}

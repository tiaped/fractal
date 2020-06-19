package org.egedede.fractal.service;

import org.egedede.fractal.model.Point;
import org.egedede.fractal.model.Session;

import java.awt.*;
import java.math.BigDecimal;

public class MandelbrotService {

    public void compute(Session<Color> session){
        EuclidianEvaluator evaluator = new EuclidianEvaluator();
        int i = 0;
        int j = 0;
        for(BigDecimal x = session.window.west; x.compareTo(session.window.east)<0;x = x.add(session.step)){
            j = 0;
            for(BigDecimal y = session.window.north; y.compareTo(session.window.south)<0;y = y.add(session.step)){
                Point p = new Point(x, y);
                MandelbrotFormula formula = new MandelbrotFormula(p);
                int iteration = 0;
                while(iteration< session.iterationModel.getMaxIteration() && evaluator.evaluate(p).compareTo(new BigDecimal("2.0"))<0){
                    p = formula.next(p);
                    iteration++;
                }
                session.fractal.set(session.iterationModel.getValue(iteration), i, j);
                j = j+1;
            }
            i=i+1;
            System.out.println(i);
        }

    }
}

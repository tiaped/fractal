package org.egedede.fractal.model;

import java.awt.*;

public class GreyIterationModel implements IterationModel {

    public final int maxIteration;
    private final double coef;

    public GreyIterationModel(int maxIteration) {
        this.maxIteration = maxIteration;
        this.coef = 255.0 / maxIteration;
    }

    @Override
    public int getMaxIteration() {
        return maxIteration;
    }

    @Override
    public Color getValue(int iteration) {
        int value = (int) (coef * iteration);
//        System.out.println("Color : "+coef+" "+iteration+" "+value);
        return new Color(value, value, value);
    }
}

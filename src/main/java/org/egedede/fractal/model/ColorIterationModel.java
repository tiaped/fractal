package org.egedede.fractal.model;

import java.awt.*;

public class ColorIterationModel implements IterationModel {

    public final int maxIteration;
    private final double coef;

    public ColorIterationModel(int maxIteration) {
        this.maxIteration = maxIteration;
        this.coef = (3*256.0-1) / maxIteration;
    }

    @Override
    public int getMaxIteration() {
        return maxIteration;
    }

    @Override
    public Color getValue(int iteration) {
        int value = (int) (coef * iteration);
        int red,blue, green;
        if(value> 512) {
           red = 255; green = 255; blue = value-512;
        } else if(value >256){
            red = 255; green = value - 256; blue = 0;
        } else {
            red = value; green = 0; blue = 0;
        }
//        System.out.println("Color : "+coef+" "+iteration+" "+value);
        return new Color(red, green, blue);
    }
}

package org.egedede.fractal.model;

import java.awt.*;

public class Fractal {
    public Color[][] data;

    public Fractal(int width, int height){
        data = new Color[width][height];
    }

    public void set(Color value, int x, int y){
        data[x][y] = value;
    }
}

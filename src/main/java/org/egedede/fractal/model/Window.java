package org.egedede.fractal.model;

import org.egedede.fractal.helpers.FractalMath;

import java.math.BigDecimal;

public class Window {
    public final BigDecimal east, west, north, south;

    private Window(double west, double east, double north, double south) {
        this.east = new BigDecimal(east, FractalMath.MATH_CONTEXT);
        this.west = new BigDecimal(west, FractalMath.MATH_CONTEXT);
        this.north = new BigDecimal(north, FractalMath.MATH_CONTEXT);
        this.south = new BigDecimal(south, FractalMath.MATH_CONTEXT);
    }

    public static Window fromXYWidthHeight(double x, double y, double width, double height) {
        return new Window(x, x+width, y, y+height);
    }

    public BigDecimal width() {
        return east.add(west.negate());
    }
    public BigDecimal height() {
        return south.add(north.negate());
    }
}

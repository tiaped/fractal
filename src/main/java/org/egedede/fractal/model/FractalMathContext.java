package org.egedede.fractal.model;

import java.math.MathContext;
import java.math.RoundingMode;

/**
 * provides allowed nb digits after the comma.
 * We only works on values in the square (2,2) (-2,-2)
 */
public class FractalMathContext {

    public final int scale;
    public final MathContext context;

    public FractalMathContext(int scale) {
        this.scale = scale;
        this.context = new MathContext(scale+1, RoundingMode.HALF_EVEN);
    }
}

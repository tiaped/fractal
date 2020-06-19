package org.egedede.fractal.service;

import org.egedede.fractal.helpers.FractalMath;
import org.egedede.fractal.model.Point;

import java.math.BigDecimal;

public class MandelbrotFormula implements Formula {

    public final Point reference;

    public MandelbrotFormula(Point reference) {
        this.reference = reference;
    }

    @Override
    public Point next(Point point) {
        Point result = new Point(
                point.x
                        .multiply(point.x, FractalMath.MATH_CONTEXT)
                        .add(point.y.multiply(point.y, FractalMath.MATH_CONTEXT).negate())
                        .add(reference.x, FractalMath.MATH_CONTEXT),
                point.y
                        .multiply(point.x, FractalMath.MATH_CONTEXT)
                        .multiply(new BigDecimal("2", FractalMath.MATH_CONTEXT))
                                .add(reference.y, FractalMath.MATH_CONTEXT)
                );
        return result;
    }
}

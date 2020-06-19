package org.egedede.fractal.service;

import org.egedede.fractal.helpers.FractalMath;
import org.egedede.fractal.model.Point;

import java.math.BigDecimal;
import java.math.MathContext;

public class EuclidianEvaluator implements Evaluator{
    @Override
    public BigDecimal evaluate(Point point) {
        final BigDecimal value = point.x.multiply(point.x).add(point.y.multiply(point.y)).sqrt(FractalMath.MATH_CONTEXT);
//        System.out.println(point+" "+value.toPlainString());
        return value;
    }
}

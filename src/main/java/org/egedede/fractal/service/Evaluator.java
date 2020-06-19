package org.egedede.fractal.service;

import org.egedede.fractal.model.Point;

import java.math.BigDecimal;

public interface Evaluator {

    BigDecimal evaluate(Point point);
}

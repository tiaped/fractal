package org.egedede.fractal.service;

import org.egedede.fractal.model.Point;

public interface Formula {

    Point next(Point point);
}

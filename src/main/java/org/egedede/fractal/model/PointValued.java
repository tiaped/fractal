package org.egedede.fractal.model;

import javax.persistence.Entity;

/**
 * Contains a point and number of iteration
 */
@Entity
public class PointValued {

    public PointValued(Point point, Integer nbIteration) {
        this.point = point;
        this.nbIteration = nbIteration;
    }

    public Point point;

    public Integer nbIteration;


}

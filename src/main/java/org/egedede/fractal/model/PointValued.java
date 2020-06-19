package org.egedede.fractal.model;

import javax.persistence.Entity;

/**
 * Contains a point and number of iteration
 */
@Entity
public class PointValued {


    public Point point;

    public Integer nbIteration;


}

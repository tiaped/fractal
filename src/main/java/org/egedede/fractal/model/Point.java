package org.egedede.fractal.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Point {
    public BigDecimal x,y;

    public Point(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y) {
        this(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
    }

    @Override
    public String toString() {
        return "Point["+x.toPlainString()+","+y.toPlainString()+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x.compareTo(point.x)==0 &&
                y.compareTo(point.y)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

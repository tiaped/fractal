package org.egedede.fractal.service;

import org.egedede.fractal.model.Point;
import org.egedede.fractal.model.Window;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class PointGenerator implements Iterator<Point> {
    public final Window window;
    public final BigDecimal step;
    public BigDecimal x,y;

    /**
     * precision meant as Bigdecimal Preicion
     * @param window
     * @param precision
     */
    public PointGenerator(Window window, int scale) {
        this.window = window;
        this.step = BigDecimal.ONE.movePointLeft(scale);
        this.x = window.west.setScale(scale);
        this.y = window.north.setScale(scale);
    }

    @Override
    public boolean hasNext() {
        return this.x.compareTo(window.east)<=0;
    }

    @Override
    public Point next() {
        Point result = new Point(x, y);
        y = y.add(step);
        if(y.compareTo(window.south)>0){
            x = x .add(step);
            y = window.north.setScale(step.scale());
        }
        return result;
    }
}

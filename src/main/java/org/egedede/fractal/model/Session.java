package org.egedede.fractal.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Session<T> {

    public String id;
    public Window window;
    public BigDecimal step;
    public IterationModel iterationModel;
    public Fractal fractal;

    public Session(Window window, double step, IterationModel iterationModel) {
        this.window = window;
        this.step = new BigDecimal(step);
        this.iterationModel = iterationModel;
        this.fractal = new Fractal(getWidth(), getHeight());
    }

    public int getWidth() {
        return window.width().divide(step, RoundingMode.HALF_EVEN).intValue();
    }
    public int getHeight() {
        return window.width().divide(step, RoundingMode.HALF_EVEN).intValue();
    }
}

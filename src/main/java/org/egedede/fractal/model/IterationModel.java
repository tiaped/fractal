package org.egedede.fractal.model;

import java.awt.*;

public interface IterationModel {

    int getMaxIteration();
    Color getValue(int iteration);
}

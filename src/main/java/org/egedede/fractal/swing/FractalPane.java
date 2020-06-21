package org.egedede.fractal.swing;

import org.egedede.fractal.model.IterationModel;
import org.egedede.fractal.model.PointValued;

import javax.swing.*;
import java.awt.*;

public class FractalPane extends JComponent {
    private final IterationModel iterationModel;
    public PointValued[][] data;
    public int x;
    public int y;
    public FractalPane(PointValued[][] data, int x, int y, IterationModel iterationModel) {
        super();
        this.data = data;
        this.x = x;
        this.y = y;
        this.iterationModel = iterationModel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0;i<getSize().width;i++){
            for(int j = 0;j<getSize().height;j++){

                final Color color = x+i<data.length && y+j<data[0].length?iterationModel.getValue(data[x + i][y + j].nbIteration): Color.WHITE;
                g.setColor(color);
                g.drawLine(i, j,i, j);
            }
        }
    }

}

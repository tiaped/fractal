package org.egedede.fractal.view;

import org.egedede.fractal.model.Fractal;
import org.egedede.fractal.model.Session;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.BLACK;

public class FractalViewer {
    public Session<Color> session;

    public Image view(){
        BufferedImage image = new BufferedImage(session.getWidth(), session.getHeight() ,BufferedImage.TYPE_INT_ARGB);
        final Fractal fractal = session.fractal;
        for(int i = 0; i< session.getWidth(); i++){
            for(int j = 0; j< session.getWidth();j++){
                if(fractal.data[i][j]!=null){
                    image.setRGB(i, j, fractal.data[i][j].getRGB());
                } else {
                    image.setRGB(i, j, BLACK.getRGB());
                }
            }
        }
        return image;
    }
}

package org.egedede.fractal;

import org.egedede.fractal.model.GreyIterationModel;
import org.egedede.fractal.model.IterationModel;
import org.egedede.fractal.model.Session;
import org.egedede.fractal.model.Window;
import org.egedede.fractal.service.MandelbrotService;
import org.egedede.fractal.view.FractalViewer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainOnTheFly {
    public static void main(String[] args) throws IOException {

        MandelbrotService service = new MandelbrotService();
        IterationModel model = new GreyIterationModel(255);
        Window window = Window.fromXYWidthHeight(-2d, -2d, 4d, 4d);
        Session<Color> session = new Session<>(window, 0.0005, model);
        service.compute(session);
        FractalViewer viewer = new FractalViewer();
        viewer.session = session;
        final Image view = viewer.view();
        final File plop = File.createTempFile("plop", ".png");
        final boolean png = ImageIO.write((BufferedImage) view, "png", plop);
        Desktop.getDesktop().open(plop);
    }
}

package org.egedede.fractal;


import org.egedede.fractal.model.Point;
import org.egedede.fractal.model.Window;
import org.egedede.fractal.service.PointGenerator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PointGeneratorTest {

    @Test
    public void testSimple() {
        Window window = Window.fromXYWidthHeight(-2, -2, 2, 2);
        PointGenerator generator = new PointGenerator(window, 0);
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -2)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -1)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, 0)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-1, -2)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-1, -1)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-1, 0)));
        Point point = generator.next();
        while (generator.hasNext()) {
            point = generator.next();
        }
        assertThat(point, equalTo(new Point(0, 0)));
    }

    @Test
    public void test2Digits() {
        Window window = Window.fromXYWidthHeight(-2, -2, 2, 2);
        PointGenerator generator = new PointGenerator(window, 2);
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -2)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -1.99)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -1.98)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -1.97)));
        Point point = generator.next();
        while (generator.hasNext()) {
            point = generator.next();
        }
        assertThat(point, equalTo(new Point(0, 0)));
    }
    @Test
    public void test2DigitsNotRound() {
        Window window = Window.fromXYWidthHeight(-2, -2, 1.999, 2);
        PointGenerator generator = new PointGenerator(window, 2);
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -2)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -1.99)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -1.98)));
        assertThat(generator.hasNext(), equalTo(true));
        assertThat(generator.next(), equalTo(new Point(-2, -1.97)));
        Point point = generator.next();
        while (generator.hasNext()) {
            point = generator.next();
        }
        assertThat(point, equalTo(new Point(-0.01, 0)));
    }
}

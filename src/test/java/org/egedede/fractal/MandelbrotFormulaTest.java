package org.egedede.fractal;

import org.egedede.fractal.model.Point;
import org.egedede.fractal.service.Formula;
import org.egedede.fractal.service.MandelbrotFormula;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MandelbrotFormulaTest {

    @Test
    public void testwithPoint0_0() {
        Formula formula = new MandelbrotFormula(new Point(ZERO, ZERO));
        {
            final Point next = formula.next(new Point(ZERO, ZERO));
            assertThat(next, equalTo(new Point(ZERO, ZERO)));
        }
        {
            final Point next = formula.next(new Point(ONE, ONE));
            assertThat(next, equalTo(new Point(ZERO, new BigDecimal("2"))));
        }
        {
            final Point next = formula.next(new Point(TEN, ONE));
            assertThat(next, equalTo(new Point(new BigDecimal("99"), new BigDecimal("20"))));
        }
    }
    @Test
    public void testwithPoint1_1() {
        Formula formula = new MandelbrotFormula(new Point(ONE, ONE));
        {
            final Point next = formula.next(new Point(ZERO, ZERO));
            assertThat(next, equalTo(new Point(ONE, ONE)));
        }
        {
            final Point next = formula.next(new Point(ONE, ONE));
            assertThat(next, equalTo(new Point(ONE, new BigDecimal("3"))));
        }
        {
            final Point next = formula.next(new Point(TEN, ONE));
            assertThat(next, equalTo(new Point(new BigDecimal("100"), new BigDecimal("21"))));
        }
    }
}

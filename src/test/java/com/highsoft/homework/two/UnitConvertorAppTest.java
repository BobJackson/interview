package com.highsoft.homework.two;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class UnitConvertorAppTest {

    private final UnitConvertorApp app = new UnitConvertorApp();

    @Test
    public void testInit() {
        shouldAllToZero();
    }

    private void shouldAllToZero() {
        UnitDisplay display = app.init();
        assertEquals("[{ value=0, unit=FEET}{ value=0, unit=INCH}{ value=0, unit=YARD}]", display.toString());
    }

    @Test
    public void testConvert() {
        shouldWorkEvenWithoutUnit();
        shouldBeRightWhen5Yard();
        shouldBeRightWhen4Feet();
        shouldWorkWhen6Inch();
        shouldWorkWhenNonInteger();
    }

    private void shouldWorkWhenNonInteger() {
        UnitDisplay display = app.convert(new UnitInput(BigDecimal.valueOf(12.6), Unit.FEET));
        assertEquals("[{ value=4.20, unit=YARD}{ value=12.6, unit=FEET}{ value=151.2, unit=INCH}]", display.toString());
    }

    private void shouldWorkWhen6Inch() {
        UnitDisplay display = app.convert(new UnitInput(BigDecimal.valueOf(6), Unit.INCH));
        assertEquals("[{ value=0.17, unit=YARD}{ value=0.50, unit=FEET}{ value=6, unit=INCH}]", display.toString());
    }

    private void shouldBeRightWhen4Feet() {
        UnitDisplay display = app.convert(new UnitInput(BigDecimal.valueOf(4), Unit.FEET));
        assertEquals("[{ value=1.33, unit=YARD}{ value=4, unit=FEET}{ value=48, unit=INCH}]", display.toString());
    }

    private void shouldBeRightWhen5Yard() {
        UnitDisplay display = app.convert(new UnitInput(BigDecimal.valueOf(5), Unit.YARD));
        assertEquals("[{ value=5, unit=YARD}{ value=15, unit=FEET}{ value=180, unit=INCH}]", display.toString());
    }

    private void shouldWorkEvenWithoutUnit() {
        UnitDisplay display = app.convert(new UnitInput(BigDecimal.ONE));
        assertEquals("[{ value=1, unit=YARD}{ value=3, unit=FEET}{ value=36, unit=INCH}]", display.toString());
    }

}
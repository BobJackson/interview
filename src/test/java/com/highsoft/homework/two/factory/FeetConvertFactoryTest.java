package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FeetConvertFactoryTest {

    FeetConvertFactory factory = new FeetConvertFactory(new UnitDisplayConfig(3, BigDecimal.ROUND_HALF_UP));

    @Test
    public void getConfig() {
        shouldBeRightUsingCustomizedConfig();
    }

    private void shouldBeRightUsingCustomizedConfig() {
        UnitDisplayConfig config = factory.getConfig();
        assertEquals("UnitDisplayConfig{scale=3, roundingMode=4}", config.toString());
    }

    @Test
    public void convert() {
        List<Map<BigDecimal, Unit>> list = factory.convert(BigDecimal.valueOf(5));
        assertEquals("{1.667=YARD}", list.get(0).toString());
        assertEquals("{5=FEET}", list.get(1).toString());
        assertEquals("{60=INCH}", list.get(2).toString());
    }
}
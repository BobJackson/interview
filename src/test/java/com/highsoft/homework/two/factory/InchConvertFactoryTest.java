package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InchConvertFactoryTest {

    InchConvertFactory factory = new InchConvertFactory(UnitDisplayConfig.DEFAULT_CONFIG);

    @Test
    public void getConfig() {
        shouldBeRightWhenUsingDefaultConfig();
    }

    private void shouldBeRightWhenUsingDefaultConfig() {
        UnitDisplayConfig config = factory.getConfig();
        assertEquals("UnitDisplayConfig{scale=2, roundingMode=4}", config.toString());
    }

    @Test
    public void convert() {
        List<Map<BigDecimal, Unit>> list = factory.convert(BigDecimal.TEN);
        assertEquals("{0.28=YARD}", list.get(0).toString());
        assertEquals("{0.83=FEET}", list.get(1).toString());
        assertEquals("{10=INCH}", list.get(2).toString());
    }
}
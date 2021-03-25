package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UnitConvertFactoryTest {

    UnitConvertFactory factory = new YardConvertorFactory(UnitDisplayConfig.DEFAULT_CONFIG);

    @Test
    public void convert() {
        List<Map<BigDecimal, Unit>> list = factory.convert(new UnitInput(BigDecimal.valueOf(2), Unit.YARD));
        assertEquals("{2=YARD}", list.get(0).toString());
        assertEquals("{6=FEET}", list.get(1).toString());
        assertEquals("{72=INCH}", list.get(2).toString());
    }

    @Test
    public void getConfig() {
        UnitDisplayConfig config = factory.getConfig();
        assertEquals("UnitDisplayConfig{scale=2, roundingMode=4}", config.toString());
    }
}
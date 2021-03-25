package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class UnitConvertFactoryMakerTest {

    UnitConvertFactoryMaker maker = new UnitConvertFactoryMaker();

    @Test
    public void createFactory() {
        UnitInput input = new UnitInput(BigDecimal.TEN, Unit.INCH);
        UnitConvertFactory factory = maker.createFactory(input, UnitDisplayConfig.DEFAULT_CONFIG);
        assertEquals("com.highsoft.homework.two.factory.InchConvertFactory", factory.getClass().getName());
    }
}
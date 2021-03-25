package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YardConvertorFactory implements UnitConvertFactory {

    private UnitDisplayConfig config;

    public YardConvertorFactory() {
    }

    public YardConvertorFactory(UnitDisplayConfig config) {
        this.config = config;
    }

    @Override
    public List<Map<BigDecimal, Unit>> convert(BigDecimal value) {
        List<Map<BigDecimal, Unit>> result = new ArrayList<>();

        HashMap<BigDecimal, Unit> yardMap = new HashMap<>(1);
        yardMap.put(value, Unit.YARD);
        result.add(yardMap);

        HashMap<BigDecimal, Unit> feetMap = new HashMap<>(1);
        UnitInput yardConvert2Feet = yardConvert2Feet(value);
        feetMap.put(yardConvert2Feet.getValue(), yardConvert2Feet.getUnit());
        result.add(feetMap);

        HashMap<BigDecimal, Unit> inchMap = new HashMap<>(1);
        UnitInput yardConvert2Inch = yardConvert2Inch(value);
        inchMap.put(yardConvert2Inch.getValue(), yardConvert2Inch.getUnit());
        result.add(inchMap);

        return result;
    }

    private UnitInput yardConvert2Feet(BigDecimal value) {
        return new UnitInput(value.multiply(BigDecimal.valueOf(3L)), Unit.FEET);
    }

    private UnitInput yardConvert2Inch(BigDecimal value) {
        return new UnitInput(value.multiply(BigDecimal.valueOf(36L)), Unit.INCH);
    }

    @Override
    public void setConfig(UnitDisplayConfig config) {
        this.config = config;
    }

    @Override
    public UnitDisplayConfig getConfig() {
        return config;
    }
}

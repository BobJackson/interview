package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InchConvertFactory implements UnitConvertFactory {

    private UnitDisplayConfig config;

    public InchConvertFactory() {
    }

    public InchConvertFactory(UnitDisplayConfig config) {
        this.config = config;
    }

    @Override
    public List<Map<BigDecimal, Unit>> convert(BigDecimal value) {
        List<Map<BigDecimal, Unit>> result = new ArrayList<>();

        HashMap<BigDecimal, Unit> yardMap = new HashMap<>(1);
        UnitInput convert2Yard = inchConvert2Yard(value);
        yardMap.put(convert2Yard.getValue(), convert2Yard.getUnit());
        result.add(yardMap);

        HashMap<BigDecimal, Unit> feetMap = new HashMap<>(1);
        UnitInput convert2Feet = inchConvert2Feet(value);
        feetMap.put(convert2Feet.getValue(), convert2Feet.getUnit());
        result.add(feetMap);

        HashMap<BigDecimal, Unit> inchMap = new HashMap<>(1);
        inchMap.put(value, Unit.INCH);
        result.add(inchMap);

        return result;
    }

    private UnitInput inchConvert2Yard(BigDecimal value) {
        return new UnitInput(value.divide(BigDecimal.valueOf(36L)
                , config.getScale()
                , config.getRoundingMode()
        ), Unit.YARD);
    }

    private UnitInput inchConvert2Feet(BigDecimal value) {
        return new UnitInput(value.divide(BigDecimal.valueOf(12L)
                , config.getScale()
                , config.getRoundingMode()
        ), Unit.FEET);
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

package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeetConvertFactory implements UnitConvertFactory {

    private final UnitDisplayConfig config;

    @Override
    public UnitDisplayConfig getConfig() {
        return this.config;
    }

    public FeetConvertFactory(UnitDisplayConfig config) {
        this.config = config;
    }

    @Override
    public List<Map<BigDecimal, Unit>> convert(BigDecimal value) {
        List<Map<BigDecimal, Unit>> result = new ArrayList<>();

        HashMap<BigDecimal, Unit> yardMap = new HashMap<>(1);
        UnitInput convert2Yard = feetConvert2Yard(value);
        yardMap.put(convert2Yard.getValue(), convert2Yard.getUnit());
        result.add(yardMap);

        HashMap<BigDecimal, Unit> feetMap = new HashMap<>(1);
        feetMap.put(value, Unit.FEET);
        result.add(feetMap);

        HashMap<BigDecimal, Unit> inchMap = new HashMap<>(1);
        UnitInput convert2Inch = feetConvert2Inch(value);
        inchMap.put(convert2Inch.getValue(), convert2Inch.getUnit());
        result.add(inchMap);
        return result;
    }

    private UnitInput feetConvert2Yard(BigDecimal value) {
        return new UnitInput(value.divide(BigDecimal.valueOf(3L)
                , getConfig().getScale()
                , getConfig().getRoundingMode()
        ), Unit.YARD);
    }

    private UnitInput feetConvert2Inch(BigDecimal value) {
        return new UnitInput(value.multiply(BigDecimal.valueOf(12L)), Unit.INCH);
    }

}

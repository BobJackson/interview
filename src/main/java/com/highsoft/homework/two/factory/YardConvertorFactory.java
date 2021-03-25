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

    private final UnitDisplayConfig config;

    @Override
    public UnitDisplayConfig getConfig() {
        return this.config;
    }

    public YardConvertorFactory(UnitDisplayConfig config) {
        this.config = config;
    }

    @Override
    public List<Map<BigDecimal, Unit>> convert(UnitInput input) {
        List<Map<BigDecimal, Unit>> result = new ArrayList<>();

        HashMap<BigDecimal, Unit> yardMap = new HashMap<>(1);
        yardMap.put(input.getValue(), Unit.YARD);
        result.add(yardMap);

        HashMap<BigDecimal, Unit> feetMap = new HashMap<>(1);
        feetMap.put(input.getValue().multiply(BigDecimal.valueOf(3L)), Unit.FEET);
        result.add(feetMap);

        HashMap<BigDecimal, Unit> inchMap = new HashMap<>(1);
        inchMap.put(input.getValue().multiply(BigDecimal.valueOf(36L)), Unit.INCH);
        result.add(inchMap);

        return result;
    }
}

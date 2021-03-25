package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InchConvertorFactory implements UnitConvertFactory {

    private final UnitDisplayConfig config;

    @Override
    public UnitDisplayConfig getConfig() {
        return this.config;
    }

    public InchConvertorFactory(UnitDisplayConfig config) {
        this.config = config;
    }

    @Override
    public List<Map<BigDecimal, Unit>> convert(UnitInput input) {
        List<Map<BigDecimal, Unit>> result = new ArrayList<>();

        HashMap<BigDecimal, Unit> yardMap = new HashMap<>(1);
        yardMap.put(input.getValue().divide(BigDecimal.valueOf(36L), getConfig().getScale(), BigDecimal.ROUND_HALF_UP), Unit.YARD);
        result.add(yardMap);

        HashMap<BigDecimal, Unit> feetMap = new HashMap<>(1);
        feetMap.put(input.getValue().divide(BigDecimal.valueOf(12L), getConfig().getScale(), BigDecimal.ROUND_HALF_UP), Unit.FEET);
        result.add(feetMap);

        HashMap<BigDecimal, Unit> inchMap = new HashMap<>(1);
        inchMap.put(input.getValue(), Unit.INCH);
        result.add(inchMap);

        return result;
    }


}

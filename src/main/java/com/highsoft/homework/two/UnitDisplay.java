package com.highsoft.homework.two;

import com.highsoft.homework.two.factory.UnitConvertFactory;
import com.highsoft.homework.two.factory.UnitConvertFactoryMaker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitDisplay {

    private static final int LENGTH = Unit.values().length;
    private List<Map<BigDecimal, Unit>> values = new ArrayList<>(LENGTH);

    private final UnitDisplayConfig config;

    public UnitDisplayConfig getConfig() {
        return config;
    }

    private UnitDisplay() {
        for (Unit unit : Unit.values()) {
            HashMap<BigDecimal, Unit> hashMap = new HashMap<>(1);
            hashMap.put(BigDecimal.ZERO, unit);
            values.add(hashMap);
        }
        config = UnitDisplayConfig.DEFAULT_CONFIG;
    }


    private UnitDisplay(List<Map<BigDecimal, Unit>> values, UnitDisplayConfig config) {
        this.values = values;
        this.config = config;
    }

    public static UnitDisplay init() {
        return new UnitDisplay();
    }

    public static UnitDisplay convert(UnitInput input) {
        return convert(input, UnitDisplayConfig.DEFAULT_CONFIG);
    }

    public static UnitDisplay convert(UnitInput input, UnitDisplayConfig config) {
        UnitConvertFactory factory = new UnitConvertFactoryMaker().createFactory(input, config);
        List<Map<BigDecimal, Unit>> result = factory.convert(input.getValue());
        return new UnitDisplay(result, config);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        values.forEach((map) -> map.forEach((k, v) -> sb.append("{ value=").append(k).append(", unit=")
                .append(v.toString()).append("}")));
        sb.append("]");
        return sb.toString();
    }
}

package com.highsoft.homework.two;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitDisplay {

    private static final int LENGTH = Unit.values().length;
    private static final int SCALE = 2;
    private List<Map<BigDecimal, Unit>> values = new ArrayList<>(LENGTH);

    private UnitDisplay() {
        for (Unit unit : Unit.values()) {
            HashMap<BigDecimal, Unit> hashMap = new HashMap<>(1);
            hashMap.put(BigDecimal.ZERO, unit);
            values.add(hashMap);
        }
    }

    private UnitDisplay(List<Map<BigDecimal, Unit>> values) {
        this.values = values;
    }

    public static UnitDisplay init() {
        return new UnitDisplay();
    }

    public static UnitDisplay convert(UnitInput input) {
        List<Map<BigDecimal, Unit>> result = new ArrayList<>(LENGTH);
        Unit unit = input.getUnit();
        BigDecimal value = input.getValue();
        switch (unit) {
            case YARD:
                HashMap<BigDecimal, Unit> yardMap = new HashMap<>(1);
                yardMap.put(value, Unit.YARD);
                result.add(yardMap);

                HashMap<BigDecimal, Unit> feetMap = new HashMap<>(1);
                feetMap.put(value.multiply(BigDecimal.valueOf(3L)), Unit.FEET);
                result.add(feetMap);

                HashMap<BigDecimal, Unit> inchMap = new HashMap<>(1);
                inchMap.put(value.multiply(BigDecimal.valueOf(36L)), Unit.INCH);
                result.add(inchMap);
                break;
            case FEET:
                HashMap<BigDecimal, Unit> yardMap2 = new HashMap<>(1);
                yardMap2.put(value.divide(BigDecimal.valueOf(3L), SCALE, BigDecimal.ROUND_HALF_UP), Unit.YARD);
                result.add(yardMap2);

                HashMap<BigDecimal, Unit> feetMap2 = new HashMap<>(1);
                feetMap2.put(value, Unit.FEET);
                result.add(feetMap2);

                HashMap<BigDecimal, Unit> inchMap2 = new HashMap<>(1);
                inchMap2.put(value.multiply(BigDecimal.valueOf(12L)), Unit.INCH);
                result.add(inchMap2);
                break;
            case INCH:
                HashMap<BigDecimal, Unit> yardMap3 = new HashMap<>(1);
                yardMap3.put(value.divide(BigDecimal.valueOf(36L), SCALE, BigDecimal.ROUND_HALF_UP), Unit.YARD);
                result.add(yardMap3);

                HashMap<BigDecimal, Unit> feetMap3 = new HashMap<>(1);
                feetMap3.put(value.divide(BigDecimal.valueOf(12L), SCALE, BigDecimal.ROUND_HALF_UP), Unit.FEET);
                result.add(feetMap3);

                HashMap<BigDecimal, Unit> inchMap3 = new HashMap<>(1);
                inchMap3.put(value, Unit.INCH);
                result.add(inchMap3);
                break;
            default:
                throw new UnsupportedOperationException("暂不支持该单位转换,敬请期待!");
        }

        return new UnitDisplay(result);
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

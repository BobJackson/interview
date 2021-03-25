package com.highsoft.homework.two;

import java.math.BigDecimal;

public class UnitInput {
    private final BigDecimal value;
    private Unit unit = Unit.YARD;

    public BigDecimal getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    public UnitInput(BigDecimal value) {
        this.value = value;
    }

    public UnitInput(BigDecimal value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }
}

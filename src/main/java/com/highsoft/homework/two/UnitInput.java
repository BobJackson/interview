package com.highsoft.homework.two;

import java.math.BigDecimal;

/**
 * 单位输入，由一个值 value (BigDecimal类型) 和一个枚举 unit （Unit类型）组成 。当不传单位unit时，默认使用Unit类型 YARD （码）.
 */
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

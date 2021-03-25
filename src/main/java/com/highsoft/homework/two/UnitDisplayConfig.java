package com.highsoft.homework.two;

import java.math.BigDecimal;

/**
 * 单位换算的显示配置，目前支持scale （小数点位数）和 roundingMode（四舍五入的模式，可以参考BigDecimal类）
 */
public class UnitDisplayConfig {
    private int scale;
    private int roundingMode;

    public static final UnitDisplayConfig DEFAULT_CONFIG = new UnitDisplayConfig();

    public UnitDisplayConfig() {
        this.scale = 2;
        this.roundingMode = BigDecimal.ROUND_HALF_UP;
    }


    public UnitDisplayConfig(int scale, int roundingMode) {
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(int roundingMode) {
        this.roundingMode = roundingMode;
    }

    @Override
    public String toString() {
        return "UnitDisplayConfig{" +
                "scale=" + scale +
                ", roundingMode=" + roundingMode +
                '}';
    }
}

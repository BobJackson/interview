package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.Unit;
import com.highsoft.homework.two.UnitDisplayConfig;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UnitConvertFactory {
    List<Map<BigDecimal, Unit>> convert(BigDecimal value);

    void setConfig(UnitDisplayConfig config);

    UnitDisplayConfig getConfig();
}

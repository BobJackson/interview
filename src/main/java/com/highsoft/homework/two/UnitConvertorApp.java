package com.highsoft.homework.two;

public class UnitConvertorApp {

    public UnitDisplay init() {
        return UnitDisplay.init();
    }

    public UnitDisplay convert(UnitInput input) {
        return UnitDisplay.convert(input);
    }

    public UnitDisplay convert(UnitInput input, UnitDisplayConfig config) {
        return UnitDisplay.convert(input, config);
    }
}

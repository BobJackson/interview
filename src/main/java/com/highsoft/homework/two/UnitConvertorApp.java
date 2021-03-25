package com.highsoft.homework.two;

/**
 * UnitConvertorApp是单位换算的入口，有三个方法:<br/>
 * 1.init()用于初始化;<br/>
 * 2.convert（UnitInput input）使用默认的显示配置来换算;<br/>
 * 3.convert(UnitInput input, UnitDisplayConfig config)使用自定义显示配置的方法来换算。<br/>
 *
 */
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

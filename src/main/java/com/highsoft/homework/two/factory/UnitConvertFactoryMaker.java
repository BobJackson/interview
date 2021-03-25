package com.highsoft.homework.two.factory;

import com.highsoft.homework.two.UnitDisplayConfig;
import com.highsoft.homework.two.UnitInput;

import java.util.Locale;

/**
 * 约定1：UnitConvertFactory的实现类命名需要符合 X..ConvertFactory命名规范。
 * 约定2：UnitConvertFactory的实现类需要和当前类UnitConvertFactoryMaker同一个包。
 * 预定3：UnitConvertFactory的实现类需要有一个无参的构造函数。
 */
public class UnitConvertFactoryMaker {
    private static final String SUFFIX = "ConvertFactory";

    public UnitConvertFactory createFactory(UnitInput input, UnitDisplayConfig config) {
        String unitName = getLowerCaseUnitName(input);
        String clz = getFullyQualifiedClassName(unitName);
        try {
            Object obj = Class.forName(clz).newInstance();
            if (obj instanceof UnitConvertFactory) {
                UnitConvertFactory factory = (UnitConvertFactory) obj;
                factory.setConfig(config);
                return factory;
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("初始化UnitConvertFactoryMaker异常,请检查UnitInput对应的转化工厂类!");
    }


    private String getLowerCaseUnitName(UnitInput input) {
        return input.getUnit().name().toLowerCase(Locale.ROOT);
    }


    private String getFullyQualifiedClassName(String unitName) {
        return getCurrentClassPackageName() + "." + makeFirstLetterUpCase(unitName) + SUFFIX;
    }

    private String getCurrentClassPackageName() {
        return this.getClass().getPackage().getName();
    }

    private String makeFirstLetterUpCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

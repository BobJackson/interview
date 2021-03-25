package com.highsoft.homework.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dictionary {

    public static final String TEMPLATE_PREFIX = "$";
    public static final String TEMPLATE_SUFFIX = "$";
    public static final String EMPTY = "";
    public static final String SPACE = " ";

    private final List<Map<String,String>> rules = new ArrayList<>();


    public void add(Map<String,String> rule){
        rules.add(rule);
    }


    public List<Map<String, String>> getRules() {
        return rules;
    }

}

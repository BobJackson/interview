package com.highsoft.homework.three;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DictionaryReplacerAppTest {

    DictionaryReplacerApp app = new DictionaryReplacerApp();

    @Test
    public void shouldBeEmptyWhenDictionaryIsEmpty() {
        DictionaryInput input = new DictionaryInput("");
        Dictionary dict = new Dictionary();

        DictionaryOutput replace = app.replace(input, dict);
        assertEquals("", replace.getValue());
    }

    @Test
    public void shouldReplaceTempWhenDictionaryHasTemp() {
        DictionaryInput input = new DictionaryInput("$temp$");

        Dictionary dict = new Dictionary();
        Map<String, String> rule = new HashMap<>();
        rule.put("temp", "temporary");
        dict.add(rule);

        DictionaryOutput output = app.replace(input, dict);
        assertEquals("temporary", output.getValue());
    }

    @Test
    public void shouldReplaceAllDefinedRulesInDictionary(){
        DictionaryInput input = new DictionaryInput("$temp$ here comes the name $name$");

        Dictionary dict = new Dictionary();
        Map<String, String> rule = new HashMap<>();
        rule.put("temp", "temporary");
        rule.put("name", "John Doe");
        dict.add(rule);

        DictionaryOutput output = app.replace(input, dict);
        assertEquals("temporary here comes the name John Doe", output.getValue());
    }

    @Test
    public void shouldStayOriginalWordWhenDictionaryHasNoSuchRules(){
        DictionaryInput input = new DictionaryInput("$temp$ here comes the name $name$");

        Dictionary dict = new Dictionary();
        Map<String, String> rule = new HashMap<>();
        rule.put("hi", "hello");
        dict.add(rule);

        DictionaryOutput output = app.replace(input, dict);
        assertEquals("$temp$ here comes the name $name$", output.getValue());
    }

}
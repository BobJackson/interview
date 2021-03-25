package com.highsoft.homework.three;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.highsoft.homework.three.Dictionary.*;

public class DictionaryReplacerApp {


    public DictionaryOutput replace(DictionaryInput input, Dictionary dict) {
        List<Map<String, String>> rules = dict.getRules();

        String[] words = input.getValue().split(SPACE);

        Set<String> definedRuleKeys = rules.stream()
                .flatMap(t -> t.keySet().stream())
                .collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (needExcludedForOriginalWord(definedRuleKeys, word)) {
                sb.append(word).append(SPACE);
            } else {
                String inputKey = extractKey(word);
                for (Map<String, String> rule : rules) {
                    sb.append(rule.getOrDefault(inputKey, word)).append(SPACE);
                }
            }
        }

        String result = removeLastAppendedSpace(sb);
        return new DictionaryOutput(result);
    }

    private boolean needExcludedForOriginalWord(Set<String> definedRuleKeys, String word) {
        return definedRuleKeys.contains(word);
    }

    private String removeLastAppendedSpace(StringBuilder sb) {
        String temp = sb.toString();
        return temp.length() > 0 ? temp.substring(0, temp.length() - 1) : temp;
    }

    private String extractKey(String value) {
        return value.replace(TEMPLATE_PREFIX, EMPTY).replace(TEMPLATE_SUFFIX, EMPTY);
    }
}

package com.highsoft.homework.one;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzSolution {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add("" + i);
            }
        }
        return result;
    }

    public List<String> fizzBuzzPlus(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0 || String.valueOf(i).contains("3")) {
                result.add("Fizz");
            } else if (i % 5 == 0 || String.valueOf(i).contains("5")) {
                result.add("Buzz");
            } else {
                result.add("" + i);
            }
        }
        return result;
    }
}

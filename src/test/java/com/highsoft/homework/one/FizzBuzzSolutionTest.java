package com.highsoft.homework.one;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzSolutionTest {

    private final FizzBuzzSolution solution = new FizzBuzzSolution();
    private static final int SCOPE = 100;

    @Test
    public void fizzBuzz() {
        List<String> result = solution.fizzBuzz(SCOPE);
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("Fizz", result.get(2));
        assertEquals("4", result.get(3));
        assertEquals("Buzz", result.get(4));
        assertEquals("Fizz", result.get(5));
        assertEquals("7", result.get(6));
        assertEquals("8", result.get(7));
        assertEquals("Fizz", result.get(8));
        assertEquals("Buzz", result.get(9));
        assertEquals("11", result.get(10));
        assertEquals("Fizz", result.get(11));
        assertEquals("13", result.get(12));
        assertEquals("14", result.get(13));
        assertEquals("FizzBuzz", result.get(14));
        assertEquals("16", result.get(15));
        assertEquals("17", result.get(16));
        assertEquals("Fizz", result.get(17));
        assertEquals("19", result.get(18));
        assertEquals("Buzz", result.get(19));
    }

    @Test
    public void fizzBuzzPlus() {
        List<String> result = solution.fizzBuzzPlus(SCOPE);
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("Fizz", result.get(2));
        assertEquals("4", result.get(3));
        assertEquals("Buzz", result.get(4));
        assertEquals("Fizz", result.get(5));
        assertEquals("7", result.get(6));
        assertEquals("8", result.get(7));
        assertEquals("Fizz", result.get(8));
        assertEquals("Buzz", result.get(9));
        assertEquals("11", result.get(10));
        assertEquals("Fizz", result.get(11));
        assertEquals("Fizz", result.get(12));
        assertEquals("14", result.get(13));
        assertEquals("FizzBuzz", result.get(14));
        assertEquals("16", result.get(15));
        assertEquals("17", result.get(16));
        assertEquals("Fizz", result.get(17));
        assertEquals("19", result.get(18));
        assertEquals("Buzz", result.get(19));
    }
}
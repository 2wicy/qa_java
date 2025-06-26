package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int expectedKittens;
    private final int inputKittens;

    public FelineParamTest(int inputKittens, int expectedKittens) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][] {
                {1, 1},
                {3, 3},
                {5, 5}
        };
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(inputKittens));
    }
}
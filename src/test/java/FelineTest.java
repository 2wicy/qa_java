package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test(expected = Exception.class)
    public void testFelineGetFoodInvalidType() throws Exception {
        new Feline().getFood("Неизвестный тип");
    }

    @Test
    public void testEatMeatDelegatesToGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }
}
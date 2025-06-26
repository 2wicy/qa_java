package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void testGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testLionWithInvalidSex() throws Exception {
        new Lion("Неизвестный пол", new Feline());
    }

    @Test(expected = Exception.class)
    public void testLionConstructorWithEmptySex() throws Exception {
        new Lion("", new Feline());
    }

    @Test(expected = Exception.class)
    public void testLionConstructorWithNullSex() throws Exception {
        new Lion(null, new Feline());
    }

    @Test
    public void testLionConstructorExceptionMessage() {
        try {
            new Lion("Кот", new Feline());
            fail("Должно было бросить исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void testLionGetFoodRealFeline() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, lion.getFood());
    }

    @Test
    public void testLionGetKittensRealFeline() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        assertEquals(1, lion.getKittens());
    }
}
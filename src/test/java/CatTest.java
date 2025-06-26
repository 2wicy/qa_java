package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsExpectedList() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        assertEquals(expected, cat.getFood());
    }

    @Test
    public void testGetFoodCallsEatMeatOnce() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(List.of("Животные"));
        cat.getFood();
        verify(feline, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));

        cat.getFood();
    }

    @Test
    public void testConstructorWithNullFeline() {
        try {
            new Cat(null);
            // Если конструктор не бросает исключение, тест должен это учитывать
        } catch (NullPointerException e) {
            fail("Конструктор Cat не должен бросать NPE при null параметре");
        }
    }
}
package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithInvalidType() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный тип");
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithNullType() throws Exception {
        Animal animal = new Animal();
        animal.getFood(null);
    }

    @Test
    public void testGetFoodExceptionMessage() {
        Animal animal = new Animal();
        try {
            animal.getFood("Неизвестный тип");
            fail("Должно было бросить исключение");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage());
        }
    }
}
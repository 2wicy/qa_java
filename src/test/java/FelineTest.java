package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int expectedKittens;
    private final int inputKittens;

    public FelineTest(int inputKittens, int expectedKittens) {
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

    @Test
    public void testEatMeatCallsGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test(expected = Exception.class)
    public void testAnimalGetFoodWithInvalidType() throws Exception {
        new Animal().getFood("Неизвестный тип");
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test(expected = Exception.class)
    public void testFelineGetFoodInvalidType() throws Exception {
        new Feline().getFood("Неизвестный тип"); // Неподдерживаемый тип
    }

    @Test
    public void testEatMeatDelegatesToGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat()); // Проверяем, что eatMeat() вызывает getFood("Хищник")
    }
}
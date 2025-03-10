package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final Feline feline = new Feline();

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] sound() {
        return new Object[][]{
                {1},
                {12},
                {23}
        };
    }

    /* Проверяем, что feline.getKittens(int) возвращает переданное значение*/
    @Test
    public void getKittensCountTest() {
        assertEquals("Кошка должна мяукать", kittensCount, feline.getKittens(kittensCount));
    }
}

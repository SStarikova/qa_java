package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CatTest {
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    /* Проверяем, что getSound возвращает "Мяу"*/
    @Test
    public void getSoundTest() {
        assertEquals("Метод getSound должен возвращать Мяу","Мяу", cat.getSound());
    }

    /* Проверяем, что getFood вызывает eatMeat у mock-предатора*/
    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
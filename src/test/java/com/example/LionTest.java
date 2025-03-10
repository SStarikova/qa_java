package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    /* Проверяем, что getKittens возвращает значение из Feline*/
    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", feline);
        assertEquals("Метод getKittens должен возвращать значение из Feline", 5, lion.getKittens());
    }

    /* Проверяем, что getFood возвращает рацион из Feline*/
    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", feline);
        assertEquals("Метод getFood должен возвращать рацион из Feline", expectedFood, lion.getFood());
    }

    /* Проверяем, что у самца есть грива*/
    @Test
    public void doesHaveManeForMaleTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    /* Проверяем, что у самки нет гривы*/
    @Test
    public void doesHaveManeForFemaleTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }

    /* Проверяем, что будет ошибка, если у льва нет пола*/
    @Test
    public void doesHaveManeForInvalidSexTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другое", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean expectedMane;
    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Object[][] mane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    /* Проверяем, есть ли грива у льва*/
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, null);
        assertEquals(expectedMane, lion.doesHaveMane());
    }
}

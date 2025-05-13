package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", feline);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetKittensCallsFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testGetFoodCallsFelineEatMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестно", feline);
    }
}

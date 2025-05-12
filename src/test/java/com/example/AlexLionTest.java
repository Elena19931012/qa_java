package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetFriends() throws Exception {
        AlexLion alex = new AlexLion(feline);
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittensAlwaysZero() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void testDoesHaveManeIsTrue() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void testGetFoodDelegatesToPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        AlexLion alex = new AlexLion(feline);
        assertEquals(expectedFood, alex.getFood());
        Mockito.verify(feline).eatMeat();
    }
}

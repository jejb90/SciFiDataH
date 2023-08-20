package com.challenge.challenge.service;

import com.challenge.challenge.dto.NumberHappy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class HappyNumberServiceTest {

    @Autowired
    private HappyNumberService happyNumberService;

    @Test
    public void testCheckHappinessWithHappyNumbers() {
        List<Integer> inputNumbers = Arrays.asList(1, 7, 10);

        List<NumberHappy> expectedResults = Arrays.asList(
                new NumberHappy(1, true),
                new NumberHappy(7, true),
                new NumberHappy(10, true)
        );

        List<NumberHappy> actualResults = happyNumberService.checkHappiness(inputNumbers);
        assertEquals(expectedResults.size(), actualResults.size());

        assertTrue(
                IntStream.range(0, expectedResults.size())
                        .allMatch(i -> expectedResults.get(i).isHappy() == actualResults.get(i).isHappy())
        );

    }

    @Test
    public void testCheckHappinessWithUnhappyNumbers() {
        List<Integer> inputNumbers = Arrays.asList(2, 4, 5);

        List<NumberHappy> expectedResults = Arrays.asList(
                new NumberHappy(2, false),
                new NumberHappy(4, false),
                new NumberHappy(5, false)
        );

        List<NumberHappy> actualResults = happyNumberService.checkHappiness(inputNumbers);

        assertEquals(expectedResults.size(), actualResults.size());

        assertTrue(
                IntStream.range(0, expectedResults.size())
                        .allMatch(i -> expectedResults.get(i).isHappy() == actualResults.get(i).isHappy())
        );
    }
}
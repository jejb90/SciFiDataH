package com.challenge.challenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NaturalNumberSumServiceTest {

    @Autowired
    private NaturalNumberSumService naturalNumberSumService;

    @Test
    public void testSumForN5() {
        int n = 5;
        int expectedSum = 15;
        int actualSum = naturalNumberSumService.calculateSum(n);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSumForN10() {
        int n = 10;
        int expectedSum = 55;
        int actualSum = naturalNumberSumService.calculateSum(n);
        assertEquals(expectedSum, actualSum);
    }
}
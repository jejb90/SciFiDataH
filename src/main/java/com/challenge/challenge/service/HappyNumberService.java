package com.challenge.challenge.service;

import com.challenge.challenge.dto.NumberHappy;

import java.util.List;

@FunctionalInterface
public interface HappyNumberService {
    List<NumberHappy> checkHappiness(List<Integer> numbers);
}
package com.challenge.challenge.response;

import com.challenge.challenge.dto.NumberHappy;

import java.util.List;

public class NumberHappyResponse {
    private List<NumberHappy> numbers;

    public NumberHappyResponse(List<NumberHappy> numbers) {
        this.numbers = numbers;
    }

    public List<NumberHappy> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<NumberHappy> numbers) {
        this.numbers = numbers;
    }
}

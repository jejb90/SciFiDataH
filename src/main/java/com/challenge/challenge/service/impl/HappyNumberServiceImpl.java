package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.NumberHappy;
import com.challenge.challenge.service.HappyNumberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HappyNumberServiceImpl implements HappyNumberService {


    private boolean isHappyNumber(int number) {
        int n = number;
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    @Override
    public List<NumberHappy> checkHappiness(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new NumberHappy(number, isHappyNumber(number)))
                .collect(Collectors.toList());
    }
}

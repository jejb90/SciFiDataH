package com.challenge.challenge.service.impl;


import com.challenge.challenge.service.NaturalNumberSumService;
import org.springframework.stereotype.Service;

@Service
public class NaturalNumberSumServiceImpl implements NaturalNumberSumService {

    @Override
    public int calculateSum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must be a non-negative number");
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }
}

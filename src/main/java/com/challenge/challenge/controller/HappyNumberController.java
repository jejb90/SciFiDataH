package com.challenge.challenge.controller;

import com.challenge.challenge.dto.NumberHappy;
import com.challenge.challenge.response.NumberHappyResponse;
import com.challenge.challenge.service.HappyNumberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/checkhappiness")
public class HappyNumberController {

    private final HappyNumberService happyNumberService;

    public HappyNumberController(HappyNumberService happyNumberService) {
        this.happyNumberService = happyNumberService;
    }

    @PostMapping
    public NumberHappyResponse checkHappiness(@RequestBody List<Integer> numbers) {
        List<NumberHappy> numberHappyList = happyNumberService.checkHappiness(numbers);
        return new NumberHappyResponse(numberHappyList);
    }
}

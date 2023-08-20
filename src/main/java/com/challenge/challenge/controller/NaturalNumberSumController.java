package com.challenge.challenge.controller;

import com.challenge.challenge.response.SumResponse;
import com.challenge.challenge.service.NaturalNumberSumService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sum")
@Validated
public class NaturalNumberSumController {

    private final NaturalNumberSumService naturalNumberSumService;

    public NaturalNumberSumController(NaturalNumberSumService naturalNumberSumService) {
        this.naturalNumberSumService = naturalNumberSumService;
    }


    @GetMapping
    public ResponseEntity<SumResponse> calculateSum(@RequestParam(name = "number") @Min(value = 0, message = "number must be a non-negative integer") int number) {
        int result = naturalNumberSumService.calculateSum(number);
        SumResponse response = new SumResponse(result);
        return ResponseEntity.ok(response);
    }
}

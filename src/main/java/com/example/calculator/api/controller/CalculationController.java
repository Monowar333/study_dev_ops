package com.example.calculator.api.controller;


import com.example.calculator.api.model.CalculationModel;
import com.example.calculator.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/calculate", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;
    
    @GetMapping
    public Double calculateResult(@ModelAttribute CalculationModel model){
        return calculationService.calculate(model);
    }
}

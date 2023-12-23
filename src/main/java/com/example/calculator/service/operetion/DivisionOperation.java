package com.example.calculator.service.operetion;


import org.springframework.stereotype.Service;

@Service
public class DivisionOperation implements Operation {

    @Override
    public String getOperationValue() {
        return "/";
    }

    
    @Override
    public Double calculate(Double a, Double b) {
        return a / b;
    }
}

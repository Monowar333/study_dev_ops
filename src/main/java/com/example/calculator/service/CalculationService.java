package com.example.calculator.service;

import com.example.calculator.api.model.CalculationModel;
import com.example.calculator.service.operetion.OperationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
@RequiredArgsConstructor
public class CalculationService {

    private final OperationRegistry operationRegistry;

    public Double calculate(CalculationModel calculationModel) {
        return operationRegistry.calc(calculationModel.getFirstValue(),
                calculationModel.getSecondValue(), calculationModel.getOperation());
    }
}

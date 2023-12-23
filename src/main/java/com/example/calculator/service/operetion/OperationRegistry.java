package com.example.calculator.service.operetion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class OperationRegistry {
    private Map<String, Operation> operations;

    public OperationRegistry(List<Operation> operations) {
        this.operations = operations.stream().collect(Collectors.toMap(Operation::getOperationValue, Function.identity()));
    }
    
    public Double calc(Double a, Double b, String operetion) {
        return Optional.of(operations.get(operetion)).map(o -> o.calculate(a, b)).orElseThrow();
    }
}

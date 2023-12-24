package com.example.calculator.service;

import com.example.calculator.api.model.CalculationModel;
import com.example.calculator.service.operetion.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class CalculationServiceTest {

    CalculationService calculationService;

    static Stream<Arguments> operationData() {
        return Stream.of(
                Arguments.of(getCalculationModel(1.0D, 1.0D, "*"), 1.0D),
                Arguments.of(getCalculationModel(5.0D, 2.0D, "/"), 2.5D),
                Arguments.of(getCalculationModel(5.0D, 2.0D, "+"), 7.0D),
                Arguments.of(getCalculationModel(5.0D, 2.0D, "-"), 3.0D)
        );
    }

    @BeforeEach
    public void init() {
        List<Operation> operations = List.of(new DivisionOperation(), new PlusOperation(),
                new MinusOperation(), new MultiplicationOperation());
        OperationRegistry operationRegistry = new OperationRegistry(operations);
        calculationService = new CalculationService(operationRegistry);
    }

    @ParameterizedTest
    @MethodSource("operationData")
    void calculationServiceTest(CalculationModel model, Double expectedResult) {
        Assertions.assertEquals(expectedResult, calculationService.calculate(model));
    }

    private static CalculationModel getCalculationModel(Double firstValue, Double secondValue, String operation) {
        CalculationModel model =new CalculationModel();
        model.setFirstValue(firstValue);
        model.setSecondValue(secondValue);
        model.setOperation(operation);
        return model;
    }

}

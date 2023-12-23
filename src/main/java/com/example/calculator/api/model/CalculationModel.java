package com.example.calculator.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@EqualsAndHashCode
public class CalculationModel {

    Double firstValue;

    Double secondValue;

    String operation;

}

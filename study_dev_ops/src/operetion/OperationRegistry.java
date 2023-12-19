package operetion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OperationRegistry {

    private final Map<String, Operation> operations = new HashMap<>();
    
    public OperationRegistry() {
        DivisionOperation divisionOperation = new DivisionOperation();
        PlusOperation plusOperation = new PlusOperation();
        MultiplicationOperation multiplicationOperation = new MultiplicationOperation();
        MinusOperation minusOperation = new MinusOperation();
        operations.put(divisionOperation.getOperation(), divisionOperation);
        operations.put(minusOperation.getOperation(), minusOperation);
        operations.put(plusOperation.getOperation(), plusOperation);
        operations.put(multiplicationOperation.getOperation(), multiplicationOperation);
    }
    
    public int calc(int a, int b, String operetion) {
        return Optional.of(operations.get(operetion)).map(o -> o.calculate(a, b)).orElseThrow();
    }
}

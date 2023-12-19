package operetion;

public class MultiplicationOperation implements Operation {

    @Override
    public String getOperation() {
        return "*";
    }

    
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}

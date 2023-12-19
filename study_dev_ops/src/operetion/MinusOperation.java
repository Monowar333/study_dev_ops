package operetion;

public class MinusOperation implements Operation {

    @Override
    public String getOperation() {
        return "-";
    }

    
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

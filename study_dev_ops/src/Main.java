import operetion.OperationRegistry;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    static final OperationRegistry operationRegistry = new OperationRegistry();

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        String operation = getOperation();
        try {
            int result = operationRegistry.calc(num1, num2, operation);
            System.out.println("Result: " + result);
        } catch (NoSuchElementException e) {
            System.out.println("Incorrect input data");
        }
    }

    public static int getInt(){
        System.out.println("Input number:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Incorrect Input. please try again\"");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static String getOperation(){
        System.out.println("Input operation symbol:");
        String operation;
        if(scanner.hasNext()){
            operation = String.valueOf(scanner.next().charAt(0));
        } else {
            System.out.println("Incorrect Input. please try again");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
}
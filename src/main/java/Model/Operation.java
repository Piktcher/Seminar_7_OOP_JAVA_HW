package Model;

public class Operation {
    protected double firstNumber;
    protected String operation;
    protected double secondNumber;
    protected double result;

    public Operation(double firstNumber, String operation, double secondNumber) {
        this.firstNumber = firstNumber;
        this.operation = operation;
        this.secondNumber = secondNumber;
    }
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return firstNumber + " " +
                operation + " " + secondNumber
                + " = " + result;
    }
}

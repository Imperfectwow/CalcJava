package com.example;

public class CalculatorLogic {


    public double calculate(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
                return add(firstNumber, secondNumber);
            case "-":
                return subtract(firstNumber, secondNumber);
            case "*":
                return multiply(firstNumber, secondNumber);
            case "/":
                return divide(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return firstNumber / secondNumber;
    }
}

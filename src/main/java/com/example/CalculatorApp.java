package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

  private final TextField display = new TextField();
  private final CalculatorLogic calculatorLogic = new CalculatorLogic(); // Add this line
  private double firstNumber = 0;
  private String operator = "";
  private boolean start = true;
  private boolean start = false;
  private boolean start = true;
  private boolean start = true;
  private boolean start = false;
  private boolean start = true;
  private boolean start = true;
  private boolean start = true;
  private boolean start = true;
  private boolean start = true;
  private boolean start = true;
  private boolean start = true;

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Calculator");

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.setVgap(8);
    grid.setHgap(10);

    display.setEditable(false);
    display.setAlignment(Pos.CENTER_RIGHT);
    display.setMinSize(160, 50);
    grid.add(display, 0, 0, 4, 1);

    String[] buttons = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", "C", "=", "+"
    };

    int index = 0;
    for (int i = 1; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        Button button = createButton(buttons[index]);
        button.setMinSize(40, 40);
        grid.add(button, j, i);
        index++;
      }
    }

    Scene scene = new Scene(grid);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Button createButton(String text) {
    Button button = new Button(text);
    button.setOnAction(e -> buttonClicked(text));
    return button;
  }

  private void buttonClicked(String value) {
    switch (value) {
      case "C":
        display.setText("");
        start = true;
        break;
      case "=":
        if (!"C".equals(operator)) {
          double secondNumber = Double.parseDouble(display.getText());
          double result = calculate(firstNumber, secondNumber, operator);
          display.setText(String.valueOf(result));
          start = true;
        }
        break;
      default:
        if (start) {
          display.setText("");
          start = false;
        }
        String currentValue = display.getText();
        if (isOperator(value)) {
          firstNumber = Double.parseDouble(currentValue);
          operator = value;
          display.setText("");
        } else {
          display.setText(currentValue + value);
        }
        break;
    }
  }

  private boolean isOperator(String value) {
    return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
  }



  private double calculate(double firstNumber, double secondNumber, String operator) {
    return calculatorLogic.calculate(firstNumber, secondNumber, operator);
  }

  public static void main(String[] args) {
    launch(args);
  }
}

package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String operation = request.getParameter("operation");

        double result = 0;
        boolean error = false;
        String message = "";

        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        error = true;
                        message = "Division by zero is not allowed.";
                    }
                    break;
                default:
                    error = true;
                    message = "Invalid operation selected.";
            }
        } catch (NumberFormatException e) {
            error = true;
            message = "Invalid input. Please enter numeric values.";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>CalculatorApp</title></head><body>");
        out.println("<h1>CalculatorApp Result</h1>");
        if (error) {
            out.println("<p style='color:red;'>" + message + "</p>");
        } else {
            out.println("<p>Result: " + result + "</p>");
        }
        out.println("<a href='index.jsp'>Back to Calculator</a>");
        out.println("</body></html>");
    }
}
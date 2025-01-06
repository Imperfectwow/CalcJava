<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CalculatorApp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }
        .container {
            margin-top: 50px;
            padding: 20px;
            max-width: 400px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-left: auto;
            margin-right: auto;
        }
        h1 {
            color: #333;
        }
        label {
            font-size: 16px;
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #007BFF;
            color: white;
            font-size: 16px;
            cursor: pointer;
            border: none;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to CalculatorApp!</h1>
        <form action="CalculatorServlet" method="GET">
            <label for="number1">Number 1:</label>
            <input type="text" id="number1" name="number1" required>

            <label for="number2">Number 2:</label>
            <input type="text" id="number2" name="number2" required>

            <label for="operation">Operation:</label>
            <select id="operation" name="operation">
                <option value="add">Addition</option>
                <option value="subtract">Subtraction</option>
                <option value="multiply">Multiplication</option>
                <option value="divide">Division</option>
            </select>

            <button type="submit">Calculate</button>
        </form>
    </div>
</body>
</html>
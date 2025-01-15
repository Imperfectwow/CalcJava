<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CalculatorApp</title>
    <style>
        /* General styles */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to bottom, #eef2f3, #8e9eab);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            padding: 20px;
            max-width: 400px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #333333;
            margin-bottom: 20px;
            font-size: 24px;
        }

        form label {
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
            color: #555555;
        }

        form input, form select, form button {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px auto;
            border: 1px solid #cccccc;
            border-radius: 5px;
            font-size: 14px;
            outline: none;
        }

        form input:focus, form select:focus {
            border-color: #007BFF;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        form button {
            background-color: #007BFF;
            color: white;
            font-weight: bold;
            cursor: pointer;
            border: none;
            transition: background-color 0.3s ease;
        }

        form button:hover {
            background-color: #0056b3;
        }

        /* Responsive design */
        @media (max-width: 480px) {
            .container {
                padding: 15px;
                width: 90%;
            }

            h1 {
                font-size: 20px;
            }

            form input, form select, form button {
                font-size: 12px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>CalculatorAPP</h1>
        <form action="CalculatorServlet" method="GET">
            <label for="number1">Number 1:</label>
            <input type="text" id="number1" name="number1" placeholder="Enter first number" required>

            <label for="number2">Number 2:</label>
            <input type="text" id="number2" name="number2" placeholder="Enter second number" required>

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
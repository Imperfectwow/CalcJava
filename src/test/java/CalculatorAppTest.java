import com.example.CalculatorApp;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorAppTest {

    private final CalculatorApp calculator = new CalculatorApp();


    @BeforeAll
    public static void setUpClass() throws Exception {
        // This initializes the JavaFX environment.
        // removeas d
        new JFXPanel();
    }

    @Test
    void additionTest() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void subtractionTest() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    void multiplicationTest() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void divisionTest() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}

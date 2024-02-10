
import com.example.CalculatorLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorAppTest {

    private final CalculatorLogic calculatorLogic = new CalculatorLogic();


    @Test
    void additionTest() {
        assertEquals(5, calculatorLogic.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void subtractionTest() {
        assertEquals(1, calculatorLogic.subtract(3, 2), "3 - 2 should equal 1");
    }

    @Test
    void multiplicationTest() {
        assertEquals(6, calculatorLogic.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    void divisionTest() {
        assertEquals(2, calculatorLogic.divide(6, 3), "6 / 3 should equal 2");
    }

    @Test
    void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculatorLogic.divide(1, 0),
                "Division by zero should throw ArithmeticException");
    }
}

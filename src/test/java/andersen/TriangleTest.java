package andersen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest{

    Triangle triangle = new Triangle();
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Перед всеми тестами");
    }
    @Test
    @DisplayName("Соответствие ожидаемому верному результату")
    void complianceExpectedResult(){
        double a = triangle.squareTriangle(3,4,5);
        assertThat(a).as("Результат соответствует ожидаемому").isEqualTo(6);
    }

    @Test
    @DisplayName("Соответствие ожидаемому не верному результату")
    void ComplianceNotExpectedResult(){
        double a = triangle.squareTriangle(3,4,5);
        assertThat(a).as("Результат не соответствует ожидаемому").isNotEqualTo(12);
    }

    @Test
    @DisplayName("Проверка исключения при передаче параметров, не соответствующих треугольнику")
    void throwAnExceptionNotTriangle(){
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> triangle.squareTriangle(1,2,4));
        assertEquals("Это не треугольник", exception.getMessage());
    }
    @Test
    @DisplayName("Проверка исключения при передаче не корректных параметров")
    void throwAnExceptionNotCurrentArguments(){

        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> triangle.squareTriangle(0,-2,1));
        assertEquals("Введены некорректные данные", exception.getMessage());
    }
}

package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Calculator;


class TestCalculator {

    Calculator calculator = new Calculator();

    @Test
    public void Should_add_two_numbers_and_return_result() {
        Assertions.assertAll(
                () -> assertEquals(3, calculator.add(1,2)),
                () -> assertEquals(65, calculator.add(23,42), 65),
                () -> assertEquals(77959, calculator.add(25525,52434)),
                () -> assertEquals(19, calculator.add(15,3)) // should fail
        );
    }

    @ParameterizedTest
    @CsvSource(ints = {"1,2", "23,42", "25525,52434", "15,3"})
    public void Should_add_two_numbers_and_return_result_parameterized(int valueOne, int valueTwo) {
        Assertions.assertEquals(calculator.add(valueOne,valueTwo), valueOne+valueTwo);
    }

    @ParameterizedTest
    @CsvSource(ints = {"2,1", "42,23", "52434,25525", "15,3"})
    public void Should_substract_two_numbers_and_return_result(int valueOne, int valueTwo) {
        Assertions.assertEquals(valueOne-valueTwo, calculator.sub(valueOne,valueTwo));
    }

    @ParameterizedTest
    @CsvSource(ints = {"2,1", "42,23", "52434,25525", "15,3"})
    public void Should_multiply_two_numbers_and_return_result(int valueOne, int valueTwo) {
        Assertions.assertEquals(valueOne-valueTwo, calculator.multiply(valueOne,valueTwo));
    }

    @ParameterizedTest
    @CsvSource(ints = {"25,5", "42,7", "15000,30", "15,3"})
    public void Should_divide_two_numbers_and_return_result(int valueOne, int valueTwo) {
        Assertions.assertEquals((float)valueOne/(float)valueTwo, calculator.divide(valueOne,valueTwo));
    }

    @Test
    public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
        Assertions.assertThrows(java.lang.Exception.ArrayIndexOutOfBoundsException, calculator.divide(1,0), "ZeroDivisionError");
    }
}
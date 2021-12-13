import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.GregorianCalendar;

class TestCalendar {

    @ParameterizedTest
    @ValueSource(ints = {2020, 920, 2000, 4, 1600})
    public void Should_return_true(int year) {
        Calendar cal = new Calendar(year);
        Assertions.assertTrue(cal.isLeapYear());
    }

    @ParameterizedTest
    @ValueSource(ints = {2021, 3, 1900, 25, 2017})
    public void Should_return_false(int year) {
        Calendar cal = new Calendar(year);
        Assertions.assertFalse(cal.isLeapYear());
    }

    @ParameterizedTest
    @ValueSource(ints = {2021, 2020, 2000, 1900, 73})
    public void Should_return_if_year_is_leap(int year) {
        java.util.GregorianCalander gcal = java.util.GregorianCalendar(year, 1, 1);
        Calendar cal = new Calendar(year);
        Assertions.assertEquals(gcal.isLeapYear(), cal.isLeapYear());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, Integer.MAX_VALUE})
    public void Should_do_boundary_testing(int year) {
        java.util.GregorianCalander gcal = java.util.GregorianCalendar(year, 1, 1);
        Calendar cal = new Calendar(year);
        Assertions.assertEquals(gcal.isLeapYear(), cal.isLeapYear());
    }


}
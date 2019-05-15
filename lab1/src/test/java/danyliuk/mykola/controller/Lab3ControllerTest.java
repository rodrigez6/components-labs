package danyliuk.mykola.controller;

import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * @author Mykola Danyliuk
 */
class Lab3ControllerTest {

    private View view;
    private Lab3Controller controller;

    @BeforeEach
    void setUp() {
        view = Mockito.mock(ConsoleView.class);
        controller = new Lab3Controller(view);
    }

    @Test
    void getRationalExpression1() {
        when(view.read()).thenReturn("1").thenReturn("2").thenReturn("3").thenReturn("11").thenReturn("12").thenReturn("13");
        RationalExpression expression = controller.getRationalExpression();
        Assertions.assertNotNull(expression);
        int[] expected = new int[]{11,12,13};
        int[] actual = expression.getDenominator().getCoefficients();
        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    void getRationalExpression2() {
        when(view.read()).thenReturn("t");
        Assertions.assertThrows(NumberFormatException.class, () -> {
            controller.getRationalExpression();
        });
    }
}
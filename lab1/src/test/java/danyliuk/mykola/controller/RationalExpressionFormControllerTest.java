package danyliuk.mykola.controller;

import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Mykola Danyliuk
 */
class RationalExpressionFormControllerTest {

    private View view;
    private RationalExpressionFormController controller;

    @BeforeEach
    void setUp() {
        view = Mockito.mock(ConsoleView.class);
        controller = new RationalExpressionFormController(view);
    }

    @Test
    void getRationalExpression1() {
        when(view.readInt()).thenReturn(1);
        RationalExpression expression = controller.getRationalExpression();
        Assertions.assertNotNull(expression);
        int[] denominatorCoefficients = expression.getDenominator().getCoefficients();
        Assertions.assertEquals(denominatorCoefficients.length,1);
        Assertions.assertEquals(denominatorCoefficients[0],1);
    }

    @Test
    void getRationalExpression2() {
        when(view.readInt()).thenThrow(NumberFormatException.class);
        Assertions.assertThrows(NumberFormatException.class, () -> {
            controller.getRationalExpression();
        });
    }
}
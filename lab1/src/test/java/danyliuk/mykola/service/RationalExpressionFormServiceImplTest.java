package danyliuk.mykola.service;

import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author Mykola Danyliuk
 */
class RationalExpressionFormServiceImplTest {

    private RationalExpressionFormService service;
    private View view;

    @BeforeEach
    void setUp() {
        view = Mockito.mock(ConsoleView.class);
        service = new RationalExpressionFormServiceImpl(view);
    }

    @Test
    void getRationalExpression1() {
        when(view.readInt()).thenReturn(1);
        RationalExpression expression = service.getRationalExpression();
        Assertions.assertNotNull(expression);
    }

    @Test
    void getRationalExpression2(){
        when(view.readInt()).thenThrow(NumberFormatException.class);
        Assertions.assertThrows(NumberFormatException.class, () -> {
            service.getRationalExpression();
        });
    }
}
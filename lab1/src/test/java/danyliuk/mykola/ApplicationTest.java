package danyliuk.mykola;

import danyliuk.mykola.model.Polynomial;
import danyliuk.mykola.model.RationalExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Mykola Danyliuk
 */
class ApplicationTest {

    private Polynomial polynomial1 = new Polynomial(new double[]{1.1, 2.2});
    private Polynomial polynomial2 = new Polynomial(new double[]{3.3, 4.4});
    private RationalExpression rationalExpression = new RationalExpression(polynomial1, polynomial2);

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("invoking private method")
    void invokeAnnotatedMethods() {
        boolean actual = Application.invokeAnnotatedMethods(rationalExpression);
        assertTrue(actual);
    }

    @Test
    @DisplayName("invoking proxy")
    void invokeProxy(){
        boolean actual = Application.invokeProxy(rationalExpression);
        assertFalse(actual);
    }
}
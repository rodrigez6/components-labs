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
class Application1Test {

    private Polynomial polynomial1 = new Polynomial(new int[]{1, 2});
    private Polynomial polynomial2 = new Polynomial(new int[]{1, 3});
    private RationalExpression rationalExpression = new RationalExpression(polynomial1, polynomial2);

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("invoking private method")
    void invokeAnnotatedMethods() {
        boolean actual = Application1.invokeAnnotatedMethods(rationalExpression);
        assertTrue(actual);
    }

    @Test
    @DisplayName("invoking proxy")
    void invokeProxy(){
        boolean actual = Application1.invokeProxy(rationalExpression);
        assertFalse(actual);
    }
}
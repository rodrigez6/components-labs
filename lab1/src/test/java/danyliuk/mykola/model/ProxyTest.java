package danyliuk.mykola.model;

import danyliuk.mykola.model.Polynomial;
import danyliuk.mykola.model.Proxy;
import danyliuk.mykola.model.RationalExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @author Mykola Danyliuk
 */
class ProxyTest {

    private Polynomial polynomial1 = new Polynomial(new double[]{1.1, 2.2});
    private Polynomial polynomial2 = new Polynomial(new double[]{3.3, 4.4});
    private Polynomial polynomial3 = new Polynomial(new double[]{6.3, 4.6});
    private RationalExpression rationalExpression = new RationalExpression(polynomial1, polynomial2);
    private Proxy proxy = new Proxy(rationalExpression);
    private Class<RationalExpression> clazz = RationalExpression.class;

    @Test
    @DisplayName("exception")
    void invokeBad() {
        Assertions.assertThrows(IllegalAccessException.class, ()->{
            Method setter = clazz.getDeclaredMethod("setDenominator", Polynomial.class);
            proxy.invoke(proxy,setter,new Object[]{polynomial3});
        });
    }

    @Test
    @DisplayName("good")
    void invokeOK() throws Throwable {
        Method getter = clazz.getDeclaredMethod("getDenominator");
        Polynomial actual = (Polynomial) proxy.invoke(proxy,getter,new Object[]{});
        Polynomial expected = rationalExpression.getDenominator();
        Assertions.assertEquals(actual,expected);
    }
}
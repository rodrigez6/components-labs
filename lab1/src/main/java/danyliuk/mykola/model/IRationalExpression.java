package danyliuk.mykola.model;

/**
 * @author Mykola Danyliuk
 */
public interface IRationalExpression {

    Polynomial getNumerator();
    void setNumerator(Polynomial polynomial);
    Polynomial getDenominator();
    void setDenominator(Polynomial polynomial);
    String toString();

}

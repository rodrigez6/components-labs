package danyliuk.mykola;

import java.util.Arrays;

/**
 * @author Mykola Danyliuk
 */
public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Polynomial{");
        sb.append("coefficients=").append(Arrays.toString(coefficients));
        sb.append('}');
        return sb.toString();
    }
}

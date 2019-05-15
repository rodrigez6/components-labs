package danyliuk.mykola.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mykola Danyliuk
 */
@Data
@AllArgsConstructor
public class Polynomial {

    private int[] coefficients;

    public double calculate(double x){
        double res = 0.0;
        int length = coefficients.length;
        for(int i=0;i<length;i++){
            res += coefficients[i] * Math.pow(x, length - i - 1);
        }
        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        int length = coefficients.length;
        for(int i = 0;i<length;i++){
            sb.append(coefficients[i]).append("x^").append(length-i-1).append(i!=length-1?"+":"");
        }
        return sb.toString();
    }
}

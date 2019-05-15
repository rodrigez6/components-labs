package danyliuk.mykola.model;

import lombok.*;

/**
 * @author Mykola Danyliuk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RationalExpression implements IRationalExpression {

    private Polynomial numerator; // чисельник
    private Polynomial denominator; // знаменник

    public double calculate(double x){
        return numerator.calculate(x)/ denominator.calculate(x);
    }

    @PublicAccess
    private String info(){
        return "Private Info.";
    }


}

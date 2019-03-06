package danyliuk.mykola.model;

import lombok.*;

/**
 * @author Mykola Danyliuk
 */
@Data
@AllArgsConstructor
public class RationalExpression implements IRationalExpression {

    private Polynomial numerator; // чисельник
    private Polynomial denominator; // знаменник

    @PublicAccess
    private String info(){
        return "Private Info.";
    }
}

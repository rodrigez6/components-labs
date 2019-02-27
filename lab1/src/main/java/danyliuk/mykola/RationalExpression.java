package danyliuk.mykola;

/**
 * @author Mykola Danyliuk
 */
public class RationalExpression {

    private Polynomial numerator; // чисельник
    private Polynomial denominator; // знаменник

    public RationalExpression(Polynomial numerator, Polynomial denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @PublicAccess
    public Polynomial getNumerator() {
        return numerator;
    }

    @PrivateAccess
    public void setNumerator(Polynomial numerator) {
        this.numerator = numerator;
    }

    @PublicAccess
    public Polynomial getDenominator() {
        return denominator;
    }

    @PrivateAccess
    public void setDenominator(Polynomial denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RationalExpression{");
        sb.append("numerator=").append(numerator);
        sb.append(", denominator=").append(denominator);
        sb.append('}');
        return sb.toString();
    }

    @PublicAccess
    private String getPrivateInfo(){
        return "Private Info.";
    }
}

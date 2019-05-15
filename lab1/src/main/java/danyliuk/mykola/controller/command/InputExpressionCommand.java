package danyliuk.mykola.controller.command;

import danyliuk.mykola.model.Polynomial;
import danyliuk.mykola.model.PolynomialType;
import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.util.Parser;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;

import java.util.Properties;

import static danyliuk.mykola.controller.Property.polynomialType;
import static danyliuk.mykola.controller.Property.rationalExpression;

/**
 * @author Mykola Danyliuk
 */
public class InputExpressionCommand implements Command {

    private View view = new ConsoleView();

    @Override
    public void execute(Properties properties) {
        view.print("Enter rational expression\n");
        Polynomial numerator = readPolynomial(PolynomialType.numerator);
        Polynomial denominator = readPolynomial(PolynomialType.denominator);
        RationalExpression expression = new RationalExpression(numerator,denominator);
        properties.put(rationalExpression,expression);
    }

    private Polynomial readPolynomial(PolynomialType type){
        view.print("Enter polynomial-" + type + "\n");
        view.print("Enter size of coefficients array: ");
        int size;
        do {
            try {
                size = Parser.parseInt(view.read());
                int[] coefficients = new int[size];
                for(int i=0;i<size;i++){
                    view.print("Enter coefficient with degree #" + i + " : ");
                    do {
                        try {
                            int coefficient = Parser.parseInt(view.read());
                            coefficients[i] = coefficient;
                            break;
                        } catch (NumberFormatException e){
                            view.print("Invalid number, try again \n");
                        }
                    } while (true);
                }
                return new Polynomial(coefficients);
            } catch (NumberFormatException ignored){
                view.print("Invalid number, try again \n");
            }
        } while (true);
    }
}

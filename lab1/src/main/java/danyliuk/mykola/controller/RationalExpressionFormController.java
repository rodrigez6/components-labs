package danyliuk.mykola.controller;

import danyliuk.mykola.model.Polynomial;
import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.view.View;

/**
 * @author Mykola Danyliuk
 */
public class RationalExpressionFormController implements Controller {

    private View view;

    public RationalExpressionFormController(View view) {
        this.view = view;
    }

    @Override
    public void execute(){
        try {
            RationalExpression expression = getRationalExpression();
            view.print("Your expression: " + expression);
        } catch (NumberFormatException e){
            view.printError(e.getMessage());
        }
    }

    public RationalExpression getRationalExpression() throws NumberFormatException{
        view.print("Enter rational expression\n");
        Polynomial numerator = getPolynomial("numerator");
        Polynomial denominator = getPolynomial("denominator");
        return new RationalExpression(numerator,denominator);
    }

    private Polynomial getPolynomial(String name) throws NumberFormatException{
        view.print("Enter polynomial-" + name + "\n");
        int size = getCoefficientsSize();
        int[] coefficients = new int[size];
        for(int i=0;i<size;i++){
            int coefficient = getCoefficient(i);
            coefficients[i] = coefficient;
        }
        return new Polynomial(coefficients);
    }

    private int getCoefficientsSize() throws NumberFormatException {
        view.print("Enter size of coefficients array: ");
        return view.readInt();
    }

    // degree - степінь многочлена

    private int getCoefficient(int degree) throws NumberFormatException {
        view.print("Enter coefficient with degree #" + degree + " : ");
        return view.readInt();
    }

}
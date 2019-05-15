package danyliuk.mykola.controller.command;

import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.util.Parser;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;

import java.util.Properties;

import static danyliuk.mykola.controller.Property.rationalExpression;

/**
 * @author Mykola Danyliuk
 */
public class CalculateExpressionController implements Command {

    private View view = new ConsoleView();

    @Override
    public void execute(Properties properties) {
        RationalExpression expression = (RationalExpression) properties.get(rationalExpression);
        if(expression==null){
            view.print("No expression, create new \n");
            return;
        }
        view.print("Enter x: ");
        do {
            try {
                double x = Parser.parseDouble(view.read());
                view.print("Result of expression: " + expression.calculate(x) + '\n');
                return;
            } catch (NumberFormatException e){
                view.print("Invalid number, try again \n");
            }
        } while (true);
    }
}

package danyliuk.mykola.controller.command;

import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;

import java.util.Properties;

import static danyliuk.mykola.controller.Property.rationalExpression;

/**
 * @author Mykola Danyliuk
 */
public class OutputExpressionCommand implements Command {

    private View view = new ConsoleView();

    @Override
    public void execute(Properties properties) {
        RationalExpression expression = (RationalExpression) properties.get(rationalExpression);
        view.print("Your expression: " + expression + '\n');
    }
}

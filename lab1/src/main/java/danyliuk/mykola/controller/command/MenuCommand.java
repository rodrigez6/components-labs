package danyliuk.mykola.controller.command;

import danyliuk.mykola.controller.CommandFactory;
import danyliuk.mykola.controller.Property;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;

import java.util.Properties;

/**
 * @author Mykola Danyliuk
 */
public class MenuCommand implements Command {

    private View view = new ConsoleView();

    @Override
    public void execute(Properties properties) {
        view.print("Select: 1.Create 2.Show 3.Calculate 0.exit : ");
        String code = view.read();
        properties.put(Property.command, code);
    }
}

package danyliuk.mykola.controller;

import danyliuk.mykola.controller.command.*;

import java.util.Properties;

/**
 * @author Mykola Danyliuk
 */
public class Lab4Controller implements Controller {

    @Override
    public void execute() {
        Properties properties = new Properties();
        do {
            new MenuCommand().execute(properties);
            String code = properties.getProperty(Property.command);
            if(code.equals("0")){
                return;
            }
            Command command = CommandFactory.getInstance().getCommand(code);
            if(command!=null){
                command.execute(properties);
            }
        } while (true);
    }
}

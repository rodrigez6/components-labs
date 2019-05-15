package danyliuk.mykola.controller;

import danyliuk.mykola.controller.command.CalculateExpressionController;
import danyliuk.mykola.controller.command.Command;
import danyliuk.mykola.controller.command.InputExpressionCommand;
import danyliuk.mykola.controller.command.OutputExpressionCommand;

/**
 * @author Mykola Danyliuk
 */
public class CommandFactory {
    private static CommandFactory ourInstance = new CommandFactory();

    public static CommandFactory getInstance() {
        return ourInstance;
    }

    public Command getCommand(String code){
        switch (code){
            case "1" : return new InputExpressionCommand();
            case "2" : return new OutputExpressionCommand();
            case "3" : return new CalculateExpressionController();
            default : return null;
        }
    }

    private CommandFactory() {
    }
}

package danyliuk.mykola;

import danyliuk.mykola.controller.Controller;
import danyliuk.mykola.controller.RationalExpressionFormController;
import danyliuk.mykola.view.ConsoleView;
import danyliuk.mykola.view.View;

/**
 * @author Mykola Danyliuk
 */
public class Application3 {

    public static void main(String[] args){
        View view = new ConsoleView();
        Controller controller = new RationalExpressionFormController(view);
        controller.execute();
    }
}

package danyliuk.mykola.controller;

import danyliuk.mykola.model.RationalExpression;
import danyliuk.mykola.service.RationalExpressionFormService;
import danyliuk.mykola.service.RationalExpressionFormServiceImpl;
import danyliuk.mykola.view.View;

/**
 * @author Mykola Danyliuk
 */
public class RationalExpressionFormController implements Controller {

    private View view;
    private RationalExpressionFormService service;

    public RationalExpressionFormController(View view) {
        this.view = view;
        this.service = new RationalExpressionFormServiceImpl(view);
    }

    @Override
    public void execute(){
        try {
            RationalExpression expression = service.getRationalExpression();
            view.print("Your expression: " + expression);
        } catch (NumberFormatException e){
            view.printError(e.getMessage());
        }
    }

}
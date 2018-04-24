package factory;

import ajaxAction.AjaxActionInterface;
import creator.AjaxActionCreator;

public class AjaxActionFactory {
    public static AjaxActionInterface getAction(String action) {
        AjaxActionCreator actionCreator = AjaxActionCreator.valueOf(action);
        AjaxActionInterface currentAction = actionCreator.getAction();
        
        return currentAction;
    }
}

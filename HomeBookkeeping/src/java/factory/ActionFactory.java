package factory;

import action.ActionInterface;
import creator.ActionCreator;

public class ActionFactory {
    public static ActionInterface getAction(String action) {
        ActionCreator actionCreator = ActionCreator.valueOf(action.toUpperCase());
        ActionInterface currentAction = actionCreator.getAction();
        
        return currentAction;
    }
}

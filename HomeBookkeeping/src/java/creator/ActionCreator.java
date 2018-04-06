/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creator;

import action.ActionInterface;
import action.ActionRegistration;

/**
 *
 * @author roman
 */
public enum ActionCreator {
    REGISTRATION{{this.action = new ActionRegistration();}};
    ActionInterface action;
    
    public ActionInterface getAction() {
        return this.action;
    }
}

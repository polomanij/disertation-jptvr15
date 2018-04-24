package creator;

import action.ActionInterface;
import ajaxAction.AjaxActionInterface;

/**
 *
 * @author pupil
 */
public enum AjaxActionCreator {
    ADDINCOME;
    
    AjaxActionInterface action;
    
    public AjaxActionInterface getAction() {
        return this.action;
    }
}

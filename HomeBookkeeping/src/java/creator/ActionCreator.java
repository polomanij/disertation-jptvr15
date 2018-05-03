package creator;

import action.ActionCategoryEdit;
import action.AjaxAddReport;
import action.ActionInterface;
import action.ActionLogin;
import action.ActionRegistration;
import action.ActionWorkspace;
import action.AjaxCategoryListByType;
import action.AjaxCategoryRename;
import action.AjaxCreateCategory;

/**
 *
 * @author roman
 */
public enum ActionCreator {
    REGISTRATION{{this.action = new ActionRegistration();}},
    LOGIN{{this.action = new ActionLogin();}},
    WORKSPACE{{this.action = new ActionWorkspace();}},
    CATEGORY{{this.action = new ActionCategoryEdit();}},
    //ajax actions
    ADD_REPORT{{this.action = new AjaxAddReport();}},
    CREATE_CATEGORY{{this.action = new AjaxCreateCategory();}},
    CATEGORY_LIST_BY_TYPE{{this.action = new AjaxCategoryListByType();}},
    CATEGORY_RENAME{{this.action = new AjaxCategoryRename();}};
    
    ActionInterface action;
    
    public ActionInterface getAction() {
        return this.action;
    }
}
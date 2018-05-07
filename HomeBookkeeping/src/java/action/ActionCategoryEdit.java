package action;

import entity.Category;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import session.CategoryFacade;

public class ActionCategoryEdit implements ActionInterface {
    private CategoryFacade categoryFacade;
    
    public ActionCategoryEdit() {
        try {
            Context context;
            context = new InitialContext();
            this.categoryFacade = (CategoryFacade) context.lookup("java:module/CategoryFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось найти бин.", e);
        }
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        
        List<Category> incomesCategories = categoryFacade.findByUserWithType(user, "income", true);
        List<Category> inactiveCategories = categoryFacade.findByUserWithType(user, "income", false);
        
        request.setAttribute("incomesCategories", incomesCategories);
        request.setAttribute("inactiveCategories", inactiveCategories);
        
        return "/category.jsp";
    }
    
}

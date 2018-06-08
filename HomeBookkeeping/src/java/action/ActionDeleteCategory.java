package action;

import entity.Category;
import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import session.CategoryFacade;

public class ActionDeleteCategory implements ActionInterface {
    private CategoryFacade categoryFacade;

    public ActionDeleteCategory() {
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
        
        String categoryName = request.getParameter("category-name");
        String categoryType = request.getParameter("category-type");
        
        Category category = categoryFacade.find(categoryName, categoryType, user);
        
        categoryFacade.remove(category);
        
        return new ActionCategoryEdit().execute(request);
    }
    
}

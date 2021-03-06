package action;

import com.google.gson.Gson;
import entity.Category;
import entity.User;
import helper.CategoryHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import session.CategoryFacade;

public class AjaxCreateCategory implements ActionInterface {
    private CategoryFacade categoryFacade;

    public AjaxCreateCategory() {
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
        
        String categoryTitle = request.getParameter("newCategoryTitle");
        String categoryType = request.getParameter("newCategoryType");
        String categoryChangeType = request.getParameter("categoryChangeType");
        
        Category newCategory = new Category(categoryType, categoryTitle, user, true);
        
        List<Category> allCategoriesByType = categoryFacade.findByUserWithType(user, categoryType);
        
        for (Category category : allCategoriesByType) {
            if (categoryTitle.toLowerCase().equals(category.getName().toLowerCase())) {
                return new Gson().toJson("Category name is already exists.");
            }
        }
        
        categoryFacade.create(newCategory);
        
        if (categoryType.equals(categoryChangeType)) {
            String categoryListHtml = CategoryHelper.generateCategoryListHtml(user, categoryType, true);
            
            return new Gson().toJson(categoryListHtml);
        }
        
        return null;
    }
}

package helper;

import action.ActionRegistration;
import entity.Category;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.CategoryFacade;

public class CategoryHelper {
    private static CategoryFacade categoryFacade;

    static {
        try {
            Context context;
            context = new InitialContext();
            categoryFacade = (CategoryFacade) context.lookup("java:module/CategoryFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось найти бин.", e);
        }
    }
    
    public static String generateCategoryListHtml(User user, String type) {
            List<Category> userCategories = categoryFacade.findByUserWithType(user, type);

            String categoryListHtml = "";
            
            for (Category category : userCategories) {
                categoryListHtml += String.format("<option>%1$s</option>", category.getName());
            }
            
            return categoryListHtml;
    }
}

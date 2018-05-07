package action;

import com.google.gson.Gson;
import entity.Category;
import entity.User;
import helper.CategoryHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import session.CategoryFacade;

public class AjaxChangeActivate implements ActionInterface {
    private CategoryFacade categoryFacade;

    public AjaxChangeActivate() {
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
        
        String categoryName = request.getParameter("categoryName");
        String changedCategoryType = request.getParameter("changedCategoryType");
        String secondCategoryType = request.getParameter("secondCategoryType");
        
        boolean changedCategoryActive = Boolean.valueOf( request.getParameter("changedCategoryActive") );
        
        categoryFacade.changeActivate(categoryName, changedCategoryType, user);
        
        Map data = new HashMap<String, String>();
        
        String changedCategories = CategoryHelper.generateCategoryListHtml(user, changedCategoryType, changedCategoryActive);
        data.put("changedCategories", changedCategories);
        
        if (changedCategoryType.equals(secondCategoryType)) {
            String secondCategories = CategoryHelper.generateCategoryListHtml(user, secondCategoryType, !changedCategoryActive);
            data.put("secondCategories", secondCategories);
        }
        
        String jsonData = new Gson().toJson(data);
        
        return jsonData;
    }
    
}
package action;

import entity.Category;
import entity.Report;
import entity.User;
import helper.ReportHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import session.CategoryFacade;
import session.ReportFacade;

public class ActionWorkspace implements ActionInterface {
    private CategoryFacade categoryFacade;
    private ReportFacade reportFacade;
    
    public ActionWorkspace() {
        try {
            Context context;
            context = new InitialContext();
            this.categoryFacade = (CategoryFacade) context.lookup("java:module/CategoryFacade");
            this.reportFacade = (ReportFacade) context.lookup("java:module/ReportFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось найти бин.", e);
        }
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        
        Long credit = ReportHelper.calculateCredit(user);
        request.setAttribute("credit", credit);
        
        List<Category> incomesCategories = categoryFacade.findByUserWithType(user, "income");
        List<Category> expensesCategories = categoryFacade.findByUserWithType(user, "expense");
        
        request.setAttribute("incomesCategories", incomesCategories);
        request.setAttribute("expensesCategories", expensesCategories);
        return "/workspace.jsp";
    }
}

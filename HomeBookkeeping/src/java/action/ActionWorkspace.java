package action;

import entity.Category;
import entity.Report;
import entity.User;
import helper.ReportHelper;
import java.text.DecimalFormat;
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
        
        Double credit = ReportHelper.calculateCredit(user);
        
        List<Category> incomesCategories = categoryFacade.findByUserWithType(user, "income", true);
        List<Category> expensesCategories = categoryFacade.findByUserWithType(user, "expense", true);

        String lastIncomeText = ReportHelper.getLastReportText("income", user);
        String lastExpenseText = ReportHelper.getLastReportText("expense", user);
        
        DecimalFormat format = new DecimalFormat("#0.00");
        
        request.setAttribute("credit", format.format(credit));
        request.setAttribute("lastIncome", lastIncomeText);
        request.setAttribute("lastExpense", lastExpenseText);
        request.setAttribute("incomesCategories", incomesCategories);
        request.setAttribute("expensesCategories", expensesCategories);
        
        return "/workspace.jsp";
    }
}

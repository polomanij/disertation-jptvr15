package helper;

import action.ActionRegistration;
import entity.Report;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.CategoryFacade;
import session.ReportFacade;

public class ReportHelper {
    private static CategoryFacade categoryFacade;
    private static ReportFacade reportFacade;
    
    public ReportHelper() {
        try {
            Context context;
            context = new InitialContext();
            this.categoryFacade = (CategoryFacade) context.lookup("java:module/CategoryFacade");
            this.reportFacade = (ReportFacade) context.lookup("java:module/ReportFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось найти бин.", e);
        }
    }
    
    public static Long calculateCredit(User user) {
        //get incomes
        List<Report> incomes = reportFacade.findIncomesByUser(user);
        
        //get expenses
        List<Report> expenses = reportFacade.findExpensesByUser(user);
        
        //calculate incomes
        Long incomesSum = calculateReportSum(incomes);
        
        //calculate expenses
        Long expensesSum = calculateReportSum(expenses);
        
        //calculate credit
        Long credit;
        if ( (incomesSum - expensesSum) < 100 ) {
            credit = incomesSum - expensesSum;
        } else {
            credit = (incomesSum - expensesSum) / 100;
        }
        
        //return value
        return credit;
    }
    
    private static Long calculateReportSum(List<Report> reports) {
        Long sum = 0l;
        for (Report report : reports) {
            sum += report.getSum();
        }
        
        return sum;
    }
}

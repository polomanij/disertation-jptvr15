package helper;

import action.ActionRegistration;
import entity.Report;
import entity.User;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.ReportFacade;

public class ReportHelper {
    private static ReportFacade reportFacade;
    
    static {
        try {
            Context context;
            context = new InitialContext();
            reportFacade = (ReportFacade) context.lookup("java:module/ReportFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось найти бин.", e);
        }
    }
    
    public static String getLastReportText(String type, User user) {
        Report report = reportFacade.findLastAdded(type, user);
        
        if (report != null) {
            String reportName = report.getCategory().getName();
            Double reportSum = report.getSum().doubleValue() / 100;

            DecimalFormat format = new DecimalFormat("#0.00");
            String reportText = reportName + " - " + format.format(reportSum) + " EUR";

            return reportText;
        }
        
        return "There is no reports yet";
    }
    
    public static Double calculateCredit(User user) {
        //get incomes
        List<Report> incomes = reportFacade.findIncomesByUser(user);
        
        //get expenses
        List<Report> expenses = reportFacade.findExpensesByUser(user);
        
        //calculate incomes
        Long incomesSum = calculateReportSum(incomes);
        
        //calculate expenses
        Long expensesSum = calculateReportSum(expenses);
        
        //calculate credit
        Long creditCents = (incomesSum - expensesSum);
        Double credit = creditCents.doubleValue() / 100;
        
        //return credit value
        return credit.doubleValue();
    }
    
    private static Long calculateReportSum(List<Report> reports) {
        Long sum = 0l;
        for (Report report : reports) {
            sum += report.getSum();
        }
        
        return sum;
    }
}

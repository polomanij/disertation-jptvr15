package action;

import com.google.gson.Gson;
import entity.Category;
import entity.Report;
import entity.User;
import helper.ReportHelper;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import session.CategoryFacade;
import session.ReportFacade;

public class AjaxAddReport implements ActionInterface {

    private ReportFacade reportFacade;
    private CategoryFacade categoryFacade;

    public AjaxAddReport() {
        try {
            Context context;
            context = new InitialContext();
            this.reportFacade = (ReportFacade) context.lookup("java:module/ReportFacade");
            this.categoryFacade = (CategoryFacade) context.lookup("java:module/CategoryFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось найти бин.", e);
        }
    }

    @Override
    public String execute(HttpServletRequest request) {
        //get entered user
        User user = (User) request.getSession().getAttribute("user");
        
        //Create new report and send it to DB
        Report newReport = this.createNewReport(request, user);
        reportFacade.create(newReport);

        //calculate new credit value
        Double credit = ReportHelper.calculateCredit(user);
        
        //get report type
        String type = request.getParameter("type");
        
        //get last new report from DB
        String lastReportText = ReportHelper.getLastReportText(type, user);
        
        //create map with data will sending to web page as JSON
        Map data = new HashMap<String, String>();
        
        DecimalFormat format = new DecimalFormat("#0.00");
        
        data.put("credit", format.format(credit));
        data.put("lastReportText", lastReportText);

        //convert data to JSON
        String dataJson = new Gson().toJson(data);

        return dataJson;
    }
    
    private Report createNewReport(HttpServletRequest request, User user) {
        //get request parameters
        String type = request.getParameter("type");
        String categoryName = request.getParameter("category");
        String sumNote = request.getParameter("sum");

        //convert money sum to cents to put in DB
        Long sumCents = this.getSumCents(sumNote);

        //get category object by categoryName and user
        Category reportCategory = this.categoryFacade.find(categoryName, type, user);

        //Create new report and return it
        Report newReport = new Report(type, reportCategory, sumCents);
        
        return newReport;
    }
    
    private Long getSumCents(String sumNote) {
        Double sumCentsDouble = (Double.valueOf(sumNote)) * 100;
        Long sumCents = sumCentsDouble.longValue();
        
        return sumCents;
    }
}

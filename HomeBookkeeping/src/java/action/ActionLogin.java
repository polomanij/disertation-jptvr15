package action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ActionLogin implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        //get user parameters
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        //check parameters
        List<String> errorMessage = this.checkUserData(login, password);
        
        if (!errorMessage.isEmpty()) {
            request.setAttribute("errors", errorMessage);
            return "/signin.jsp";
        }
        //retutn result string
        return "|";
    }
    
    private List checkUserData(String login, String password) {
        List<String> errorMessage = new ArrayList<>();
        
        login = login.trim();
        if (login == null | login.isEmpty()) {
            errorMessage.add("The login field must be filled");
        }
        if (login == null | login.isEmpty()) {
            errorMessage.add("The password field must be filled");
        }
        
        return errorMessage;
    }
}
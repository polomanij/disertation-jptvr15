package action;

import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import session.UserFacade;

public class ActionLogin implements ActionInterface{
    public UserFacade userFacade;

    public ActionLogin() {
        try {
            Context context;
            context = new InitialContext();
            this.userFacade = (UserFacade) context.lookup("java:module/UserFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось нацти бин.", e);
        }
    }

    @Override
    public String execute(HttpServletRequest request) {
        //get user parameters
        String login = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();
        //check parameters
        List<String> errorMessage = this.checkUserData(login, password);
        
        if (!errorMessage.isEmpty()) {
            request.setAttribute("errors", errorMessage);
            return "/signin.jsp";
        }
        
        User user = userFacade.findByLogin(login);
        if (user == null) {
            request.setAttribute("errors", errorMessage);
            return "/signin.jsp";
        }
        //retutn result string
        return "|";
    }
    
    private List checkUserData(String login, String password) {
        List<String> errorMessage = new ArrayList<>();
        
        if (login == null | login.isEmpty()) {
            errorMessage.add("The login field must be filled");
        }
        if (login == null | login.isEmpty()) {
            errorMessage.add("The password field must be filled");
        }
        
        return errorMessage;
    }
}
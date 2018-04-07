package action;

import javax.servlet.http.HttpServletRequest;
import action.ActionInterface;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import security.PasswordEncryption;
import session.UserFacade;

public class ActionRegistration implements ActionInterface {
    public UserFacade userFacade;

    public ActionRegistration() {
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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //check parameters
        List<String> errorMessage = this.checkUserData(name, surname, login, email, password);
        
        if (!errorMessage.isEmpty()) {
            //do something
        }

        //get salts for password
        String salts = PasswordEncryption.getSalts();
        
        //password encrypting
        password = salts + password;
        password = PasswordEncryption.getEncriptString(password);
        
        //creating new user
        User user = new User(name, surname, login, email, password, salts);
        
        userFacade.create(user);
        //return result string
        return "/index.jsp";
    }
    
    private List checkUserData(String name, String surname, String login, String email, String password) {
        List<String> errorMessage = new ArrayList();

        if (name == null) {
           errorMessage.add("The name field must be filled");
        }
        if (surname == null) {
           errorMessage.add("The surname field must be filled");
        }
        if (login == null) {
           errorMessage.add("The login field must be filled");
        }
        if (email == null) {
           errorMessage.add("The email field must be filled");
        }
        if (password == null) {
           errorMessage.add("The password field must be filled");
        }
        
        return errorMessage;
    }
}

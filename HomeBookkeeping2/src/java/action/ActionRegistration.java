package action;

import javax.servlet.http.HttpServletRequest;
import action.ActionInterface;
import entity.Role;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import security.PasswordEncryption;
import session.RoleFacade;
import session.UserFacade;

public class ActionRegistration implements ActionInterface {
    public UserFacade userFacade;
    public RoleFacade roleFacade;

    public ActionRegistration() {
        try {
            Context context;
            context = new InitialContext();
            this.userFacade = (UserFacade) context.lookup("java:module/UserFacade");
            this.roleFacade = (RoleFacade) context.lookup("java:module/RoleFacade");
        } catch (NamingException e) {
            Logger.getLogger(ActionRegistration.class.getName()).log(Level.SEVERE, "Не удалось нацти бин.", e);
        }
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        //get user parameters
        String name = request.getParameter("name").trim();
        String surname = request.getParameter("surname").trim();
        String login = request.getParameter("login").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        //check parameters
        List<String> errorMessage = this.checkUserData(name, surname, login, email, password);
        request.setAttribute("errors", errorMessage);
        
        if (!errorMessage.isEmpty()) {
            return "/signup.jsp";
        }

        //get salts for password
        String salts = PasswordEncryption.getSalts();
        
        //password encrypting
        password = salts + password;
        password = PasswordEncryption.getEncriptString(password);
        
        //creating new user
        User user = new User(name, surname, login, email, password, salts);
        userFacade.create(user);
        
        Role role = new Role("user", user);
        roleFacade.create(role);
        //return result string
        return "/index.jsp";
    }
    
    private List checkUserData(String name, String surname, String login, String email, String password) {
        List<String> errorMessage = new ArrayList();

        if (name == null | name.isEmpty()) {
           errorMessage.add("The name field must be filled");
        }
        if (surname == null | surname.isEmpty()) {
           errorMessage.add("The surname field must be filled");
        }
        if (login == null | login.isEmpty()) {
           errorMessage.add("The login field must be filled");
        }
        if (email == null | email.isEmpty()) {
           errorMessage.add("The email field must be filled");
        }
        if (password == null | password.isEmpty()) {
           errorMessage.add("The password field must be filled");
        }
        
        return errorMessage;
    }
}

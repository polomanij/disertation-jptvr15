package action;

import javax.servlet.http.HttpServletRequest;

public interface ActionInterface {
    String execute(HttpServletRequest request);
}

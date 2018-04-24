package ajaxAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AjaxActionInterface {
    String execute(HttpServletRequest request);
}

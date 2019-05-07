package controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        session.removeAttribute("name");
        session.invalidate();
        response.sendRedirect("jsp/user/home-logged-in.jsp");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doPost(request,response);
    }
}

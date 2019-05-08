package controller.actions.user;

import controller.actions.IAction;
import utilities.ControlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ControlSession.deleteSession(request);
        response.sendRedirect("/home");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doPost(request,response);
    }
}

package controller.actions.admin.access;

import controller.actions.IAction;
import utilities.ControlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogOutAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ControlSession.deleteSession(request);
        response.sendRedirect("/admin");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doPost(request,response);
    }
}

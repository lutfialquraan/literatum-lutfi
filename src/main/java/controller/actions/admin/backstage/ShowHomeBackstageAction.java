package controller.actions.admin.backstage;

import controller.actions.IAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHomeBackstageAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGet(request,response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/backstage/backstage-home.jsp");
        dispatcher.forward(request,response);
    }
}

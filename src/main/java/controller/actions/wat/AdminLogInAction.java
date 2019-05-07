package controller.actions.wat;

import controller.actions.IAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogInAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/wat/admin-login.jsp");
        dispatcher.forward(request,response);
    }
}

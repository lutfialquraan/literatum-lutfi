package controller.actions.wat;

import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserAction implements IAction {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("email");

        DAO userDAO = new UsersDAO();
        userDAO.delete(email);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/list-users.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/delete-user.jsp");
        requestDispatcher.forward(request,response);
    }
}

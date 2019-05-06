package controller.actions.wat;

import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;
import model.users.AbstractBaseUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListUsersAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DAO userDAO = new UsersDAO();
        List<AbstractBaseUser> users = (List<AbstractBaseUser>)(List<?>) userDAO.selectAll();
        request.setAttribute("users",users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/list-users.jsp");
        requestDispatcher.forward(request,response);
    }
}

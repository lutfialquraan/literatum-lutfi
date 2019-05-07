package controller.actions.admin.users;

import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;
import model.users.AbstractBaseUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUsersAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DAO userDAO = new UsersDAO();
        List<AbstractBaseUser> users = (List<AbstractBaseUser>)(List<?>) userDAO.selectAll();
        request.setAttribute("users",users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/users/show-user.jsp");
        requestDispatcher.forward(request,response);
    }
}

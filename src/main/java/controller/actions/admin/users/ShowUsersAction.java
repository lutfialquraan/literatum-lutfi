package controller.actions.admin.users;

import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;
import model.enums.Role;
import model.users.AbstractBaseUser;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUsersAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            DAO userDAO = new UsersDAO();
            List<AbstractBaseUser> users = (List<AbstractBaseUser>) (List<?>) userDAO.selectAll();
            request.setAttribute("users", users);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/users/show-users.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }
    }
}

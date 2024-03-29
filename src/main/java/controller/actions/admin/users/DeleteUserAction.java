package controller.actions.admin.users;

import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;
import model.enums.Role;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserAction implements IAction {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && AccessControl.isSuperAdmin(role)) {
            String email = request.getParameter("email");

            DAO userDAO = new UsersDAO();
            userDAO.delete(email);

            response.sendRedirect("/admin/users/showUsers");
        } else {
            response.sendRedirect("/admin");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && AccessControl.isSuperAdmin(role)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/users/delete-user.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }
    }
}

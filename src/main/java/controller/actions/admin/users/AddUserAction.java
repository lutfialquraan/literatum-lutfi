package controller.actions.admin.users;

import at.favre.lib.crypto.bcrypt.BCrypt;
import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;
import model.enums.Role;
import model.users.AbstractBaseUser;
import model.users.Admin;
import model.users.BasicUser;
import model.users.SuperAdmin;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && AccessControl.isSuperAdmin(role)) {
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String user_name = request.getParameter("user_name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String type = request.getParameter("type");

            char[] encryptedText = BCrypt.withDefaults().hashToChar(12, password.toCharArray());
            password = new String(encryptedText);


            AbstractBaseUser baseUser = null;
            switch (type) {
                case "User":
                    baseUser = new BasicUser(first_name, last_name, user_name, email, password);
                    break;
                case "Admin":
                    baseUser = new Admin(first_name, last_name, user_name, email, password);
                    break;
                case "SuperAdmin":
                    baseUser = new SuperAdmin(first_name, last_name, user_name, email, password);
                    break;
            }

            DAO userDAO = new UsersDAO();
            userDAO.insert(baseUser);

            response.sendRedirect("/admin/users/showUsers");
        } else {
            response.sendRedirect("/admin");
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && AccessControl.isSuperAdmin(role)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/users/add-user.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }

    }
}
package controller.actions.admin.users;

import at.favre.lib.crypto.bcrypt.BCrypt;
import controller.actions.IAction;
import model.database.DAO;
import model.database.LicenseDAO;
import model.database.UsersDAO;
import model.enums.Role;
import model.license.License;
import model.users.AbstractBaseUser;
import model.users.Admin;
import model.users.BasicUser;
import model.users.SuperAdmin;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class AddLicenseAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            String email = request.getParameter("email");
            LocalDate date = LocalDate.now();
            date = date.plusDays(Integer.parseInt(request.getParameter("date")));

            License license = new License(email,date);

            DAO licenseDAO = new LicenseDAO();
            licenseDAO.insert(license);
            response.sendRedirect("/admin/showLicense");
        } else {
            response.sendRedirect("/admin");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/license/add-license.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }

    }
}
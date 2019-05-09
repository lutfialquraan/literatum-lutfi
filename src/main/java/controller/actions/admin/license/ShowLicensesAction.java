package controller.actions.admin.license;

import controller.actions.IAction;
import model.contents.ContentMeta;
import model.database.ContentMetaDAO;
import model.database.DAO;
import model.database.LicenseDAO;
import model.enums.Role;
import model.license.License;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowLicensesAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            DAO licenseDAO = new LicenseDAO();
            List<License> license = (List<License>) (List<?>) licenseDAO.selectAll();
            request.setAttribute("license", license);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/license/show-licenses.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }

    }
}

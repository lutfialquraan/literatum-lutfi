package controller.actions.admin.contents;

import controller.actions.IAction;
import model.database.ContentMetaDAO;
import model.database.DAO;
import model.enums.Role;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteContentAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            String doi = request.getParameter("doi");

            DAO contentDAO = new ContentMetaDAO();
            contentDAO.delete(doi);
            response.sendRedirect("/admin/content");
        } else {
            response.sendRedirect("/admin");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/content/delete-content.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }
    }
}

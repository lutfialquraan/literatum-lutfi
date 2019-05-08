package controller.actions.admin.contents;

import controller.actions.IAction;
import model.contents.ContentMeta;
import model.database.ContentMetaDAO;
import model.database.DAO;
import model.enums.Role;
import utilities.AccessControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowContentsAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Role role = (Role) request.getSession().getAttribute("role");
        if (AccessControl.isLoggedIn(request) && (AccessControl.isAdmin(role) || AccessControl.isSuperAdmin(role))) {
            DAO contentMetaDAO = new ContentMetaDAO();
            List<ContentMeta> metas = (List<ContentMeta>) (List<?>) contentMetaDAO.selectAll();
            request.setAttribute("metas", metas);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/content/show-contents.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/admin");
        }
    }
}

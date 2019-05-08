package controller.actions.admin.contents;

import controller.actions.IAction;
import model.contents.ContentMeta;
import model.database.ContentMetaDAO;
import model.database.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowContentsAction implements IAction{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO contentMetaDAO = new ContentMetaDAO();
        List<ContentMeta> metas = (List<ContentMeta>)(List<?>) contentMetaDAO.selectAll();
        request.setAttribute("metas",metas);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/content/show-contents.jsp");
        requestDispatcher.forward(request,response);

    }
}

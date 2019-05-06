package controller.actions.wat;

import controller.actions.IAction;
import model.ContentMeta;
import model.database.ContentMetaDAO;
import model.database.DAO;
import model.database.UsersDAO;
import model.users.AbstractBaseUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListContentsAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO contentMetaDAO = new ContentMetaDAO();

        List<ContentMeta> meta = (List<ContentMeta>)(List<?>) contentMetaDAO.selectAll();
        request.setAttribute("meta",meta);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/list-content.jsp");
        requestDispatcher.forward(request,response);

    }
}

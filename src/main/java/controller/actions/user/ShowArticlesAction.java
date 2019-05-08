package controller.actions.user;

import controller.actions.IAction;
import model.contents.ContentMeta;
import model.database.ContentMetaDAO;
import model.database.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowArticlesAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DAO contentMetaDAO = new ContentMetaDAO();

        List<ContentMeta> meta = (List<ContentMeta>) (List<?>) contentMetaDAO.selectAll();

        HttpSession session = request.getSession();
        session.setAttribute("meta", meta);

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user/home-logged-in.jsp");
        dispatcher.forward(request, response);
    }
}

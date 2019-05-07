package controller.actions;

import utilities.DirectoryPaths;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetArticleAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String doi = request.getParameter("doi");
        String html = DirectoryPaths.CONTENTS_FILE_PATH + doi + ".html";
        String pdf = DirectoryPaths.CONTENTS_FILE_PATH + doi + ".pdf";

        HttpSession session = request.getSession();
        session.setAttribute("pdf",pdf);
        session.setAttribute("html",html);

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/preview/get-article.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    }
}

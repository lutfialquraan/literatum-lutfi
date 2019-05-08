package controller.actions.user;

import controller.actions.IAction;
import utilities.AccessControl;
import utilities.DirectoryPaths;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Scanner;

public class GetArticleAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (AccessControl.isLoggedIn(request)) {
            String doi = request.getParameter("doi");
            String htmlPath = DirectoryPaths.CONTENTS_FILE_PATH + doi + ".html";
            String pdf = DirectoryPaths.CONTENTS_FILE_PATH + doi + ".pdf";

            StringBuilder html = new StringBuilder();

            Scanner scanner = new Scanner(new File(htmlPath));
            while (scanner.hasNext()) {
                html.append(scanner.nextLine());
            }

            System.out.println(html.toString());

            HttpSession session = request.getSession();
            session.setAttribute("pdf", pdf);
            session.setAttribute("html", html.toString());

            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user/get-article.jsp");
            dispatcher.forward(request, response); }
        else {
            response.sendRedirect("/home");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doPost(request, response);
    }
}

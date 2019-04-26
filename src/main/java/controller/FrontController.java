package controller;

import controller.actions.FindAction;
import controller.actions.IAction;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "/FrontController", urlPatterns = "/all")
public class FrontController extends HttpServlet {


    private static final String PATH = "/all";


    public static RequestDispatcher getRequestDispatcher(ServletContext servletContext) {
        return servletContext.getRequestDispatcher(PATH);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            IAction action = FindAction.getAction((String) req.getAttribute("action"));
            action.execute(req,res);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

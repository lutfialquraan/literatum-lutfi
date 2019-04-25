package controller;

import controller.actions.FindAction;
import controller.actions.IAction;
import controller.actions.WelcomeAction;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


@WebServlet(name = "/my", urlPatterns = {"/home"})
public class FrontController extends HttpServlet {



    private static final String PATH = "/home";


    public static RequestDispatcher getRequestDispatcher(ServletContext servletContext) {
        return servletContext.getRequestDispatcher(PATH);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            IAction action = FindAction.findAction((String) req.getAttribute("action"));
            action.execute(req, res);

        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

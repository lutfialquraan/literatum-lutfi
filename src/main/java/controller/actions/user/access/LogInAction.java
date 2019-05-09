package controller.actions.user.access;

import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;
import model.users.AbstractBaseUser;
import utilities.ControlSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static utilities.AccessControl.isAuthenticated;

public class LogInAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DAO usersDAO = new UsersDAO();
        AbstractBaseUser baseUser = (AbstractBaseUser) usersDAO.select(email);

        boolean isAuthenticated = isAuthenticated(password, baseUser.getPassword());


        if (isAuthenticated) {
            ControlSession.createSession(request, baseUser);
            response.sendRedirect("/showArticles");
        } else {
            doGet(request, response);
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/user/log-in.jsp");
        requestDispatcher.forward(request, response);
    }
}

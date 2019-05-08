package controller.actions.admin.access;
import controller.actions.IAction;
import model.database.DAO;
import model.database.UsersDAO;
import model.users.AbstractBaseUser;
import utilities.AccessControl;
import utilities.ControlSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogInAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DAO usersDAO = new UsersDAO();
        AbstractBaseUser baseUser = (AbstractBaseUser) usersDAO.select(email);

        boolean isLoggedIn = AccessControl.isAuthenticated(password,baseUser.getPassword());

        boolean isAdmin = AccessControl.isAdmin(baseUser.getRole());

        boolean isSuperAdmin = AccessControl.isSuperAdmin(baseUser.getRole());

        if (isLoggedIn && (isAdmin || isSuperAdmin))
        {
            ControlSession.createSession(request,baseUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/access/admin-home.jsp");
            dispatcher.forward(request,response);
        }

        else {
            doGet(request,response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/access/admin-login.jsp");
        dispatcher.forward(request,response);
    }


}

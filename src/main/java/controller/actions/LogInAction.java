package controller.actions;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.database.DAO;
import model.database.UsersDAO;
import model.users.AbstractBaseUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInAction implements IAction {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DAO usersDAO = new UsersDAO();
        AbstractBaseUser baseUser = (AbstractBaseUser) usersDAO.select(email);

        boolean flag = BCrypt.verifyer().verify(password.getBytes(),baseUser.getPassword().getBytes()).verified;

        if (flag)
        {
            HttpSession session = request.getSession();
            session.setAttribute("name",baseUser.getFirstName());
            response.sendRedirect("/showArticles");
        }

        else {
            doGet(request,response);
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/admin/log-in.jsp");
        requestDispatcher.forward(request,response);
    }
}

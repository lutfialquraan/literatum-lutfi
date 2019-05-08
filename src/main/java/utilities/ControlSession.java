package utilities;

import model.users.AbstractBaseUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class ControlSession {

    private ControlSession() {
    }

    public static void createSession(HttpServletRequest request, AbstractBaseUser baseUser) {
        HttpSession session = request.getSession();
        session.setAttribute("role",baseUser.getRole());
        session.setAttribute("name", baseUser.getFirstName());
    }

    public static void deleteSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.removeAttribute("name");
        session.removeAttribute("role");
        session.invalidate();
    }
}

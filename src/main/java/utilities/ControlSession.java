package utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class ControlSession {

    private ControlSession() {
    }

    public static void createSession(HttpServletRequest request,String name) {

        HttpSession session = request.getSession();
        session.setAttribute("name", name);
    }

    public static void deleteSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.removeAttribute("name");
        session.invalidate();
    }

}

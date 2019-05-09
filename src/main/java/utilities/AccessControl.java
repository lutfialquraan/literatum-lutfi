package utilities;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.database.DAO;
import model.database.LicenseDAO;
import model.enums.Role;
import model.license.License;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;


public final class AccessControl {

    private AccessControl() {
    }

    public static boolean isAuthenticated(String passwordByUser, String passwordInDataBase) {
        boolean flag = BCrypt.verifyer().verify(passwordByUser.getBytes(), passwordInDataBase.getBytes()).verified;

        return flag;
    }

    public static boolean isUser(Role role) {

        if (role==Role.USER)
            return true;

        return false;
    }

    public static boolean isAdmin(Role role) {
        if (role==Role.ADMIN)
            return true;
        return false;
    }

    public static boolean isSuperAdmin(Role role) {
        if (role==Role.SUPERADMIN)
            return true;

        return false;
    }

    public static boolean isLoggedIn(HttpServletRequest request)
    {
        boolean allowed = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("name")!=null)
        {
          allowed = true;
        }
        return allowed;
    }

    public static boolean hasLicense (HttpServletRequest request)
    {
        boolean allowed = false;
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if (email!=null)
        {
            DAO licenseDAO = new LicenseDAO();
            License license = (License) licenseDAO.select(email);
            LocalDate today = LocalDate.now();
            LocalDate expiry = license.getDate();

            if (expiry.compareTo(today)>0)
            {
                allowed = true;
            }
        }

        return allowed;
    }
}
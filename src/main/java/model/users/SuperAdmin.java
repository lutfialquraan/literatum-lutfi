package model.users;

import model.enums.Role;

public class SuperAdmin extends AbstractBaseUser {

    public SuperAdmin(String firstName, String lastName, String userName, String email, String password) {
        super(firstName, lastName, userName, email, password, Role.SUPERADMIN);
    }
}

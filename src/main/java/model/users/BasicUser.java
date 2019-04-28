package model.users;

import model.enums.Role;

public class BasicUser extends AbstractBaseUser {

    public BasicUser(String firstName, String lastName, String userName, String email, String password) {
        super(firstName, lastName, userName, email, password, Role.USER);
    }
}

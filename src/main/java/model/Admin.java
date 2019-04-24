package model;

public class Admin extends AbstractBaseUser {

    public Admin(String firstName, String lastName, String userName, String email, String password) {
        super(firstName, lastName, userName, email, password, Role.ADMIN);
    }
}

package model;

public class User extends AbstractBaseUser {
    public User(String firstName, String lastName, String userName, String email, String password) {
        super(firstName, lastName, userName, email, password, Role.USER);
    }
}

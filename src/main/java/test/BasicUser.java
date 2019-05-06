package test;

public class BasicUser extends AbstractBaseUser {
    public BasicUser(String firstName, String lastName, String userName, String email, String password) {
        super(firstName, lastName, userName, email, password, Role.USER);
    }
}

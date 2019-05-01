package model.users;

import model.enums.Role;

public class BasicUser extends AbstractBaseUser {

    private int license;

    public BasicUser(String firstName, String lastName, String userName, String email, String password) {
        super(firstName, lastName, userName, email, password, Role.USER);
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }
}

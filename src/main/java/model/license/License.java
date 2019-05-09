package model.license;

import java.time.LocalDate;

public class License {
    private int id;
    private String email;
    private LocalDate date;

    public License(int id, String email, LocalDate date) {
        this.id = id;
        this.email = email;
        this.date = date;
    }

    public License(String email, LocalDate date) {
        this.email = email;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

package model;

public class ContentMeta {

    private String theDoi;
    private String subject;
    private String title;
    private String autor;

    public ContentMeta(String theDoi, String subject, String title, String autor) {
        this.theDoi = theDoi;
        this.subject = subject;
        this.title = title;
        this.autor = autor;
    }


    public String getTheDoi() {
        return theDoi;
    }

    public void setTheDoi(String theDoi) {
        this.theDoi = theDoi;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

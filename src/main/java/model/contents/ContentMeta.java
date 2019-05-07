package model.contents;

public class ContentMeta {

    private String theDoi;
    private String subject;
    private String title;
    private String author;

    public ContentMeta(String theDoi, String subject, String title, String author) {
        this.theDoi = theDoi;
        this.subject = subject;
        this.title = title;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ContentMeta{" +
                "theDoi='" + theDoi + '\'' +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

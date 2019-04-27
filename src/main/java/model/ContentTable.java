package model;

public class ContentTable {

    private String pathForPdf;
    private String pathForHtml;
    private String pathForXml;
    private String theDoi;

    public ContentTable(String pathForPdf, String pathForHtml, String pathForXml, String theDoi) {
        this.pathForPdf = pathForPdf;
        this.pathForHtml = pathForHtml;
        this.pathForXml = pathForXml;
        this.theDoi = theDoi;
    }

    public String getPathForPdf() {
        return pathForPdf;
    }

    public void setPathForPdf(String pathForPdf) {
        this.pathForPdf = pathForPdf;
    }

    public String getPathForHtml() {
        return pathForHtml;
    }

    public void setPathForHtml(String pathForHtml) {
        this.pathForHtml = pathForHtml;
    }

    public String getPathForXml() {
        return pathForXml;
    }

    public void setPathForXml(String pathForXml) {
        this.pathForXml = pathForXml;
    }

    public String getTheDoi() {
        return theDoi;
    }

    public void setTheDoi(String theDoi) {
        this.theDoi = theDoi;
    }

    @Override
    public String toString() {
        return "ContentTable{" +
                "pathForPdf='" + pathForPdf + '\'' +
                ", pathForHtml='" + pathForHtml + '\'' +
                ", pathForXml='" + pathForXml + '\'' +
                ", theDoi='" + theDoi + '\'' +
                '}';
    }
}

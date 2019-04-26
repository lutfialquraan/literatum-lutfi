package model;

import model.enums.Status;

public class UnprocessedFile {


    private String filePath;
    private Status status;
    private int fileId;


    public UnprocessedFile(String filePath, Status status, int fileId) {
        this.filePath = filePath;
        this.status = status;
        this.fileId = fileId;
    }

    public UnprocessedFile(String filePath, Status status) {
        this.filePath = filePath;
        this.status = status;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}

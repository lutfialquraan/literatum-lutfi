package utilities;


import model.ContentMeta;
import model.database.ContentMetaDAO;
import model.database.DAO;
import model.database.UnprocessedFileDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProcessingFiles implements Runnable {

    String zippedFile;

    public ProcessingFiles(String zippedFile) {
        this.zippedFile = zippedFile;
    }

    private File selectFile(File[] files, String selectedFile) {
        File file;
        if (files[0].getName().equalsIgnoreCase(selectedFile)) {
            file = files[1];
        } else {
            file = files[0];
        }

        return file;
    }

    public File[] findFiles(File file) {

        File[] fileNames = new File[2];
        String[] selectedFiles = {"manifest.xml", "issue-files"};
        File file1 = file;
        for (String selected : selectedFiles) {
            file1 = selectFile(file1.listFiles(), selected);
        }

        for (File file2 : file1.listFiles()) {
            if ((file2.getName().endsWith(".xml"))) {
                fileNames[0] = file2;
            } else if (file2.getName().endsWith(".pdf")) {
                fileNames[1] = file2;
            }
        }
        return fileNames;
    }

    public void copyFiles(File[] files) {
        try {
            for (File file : files) {
                Path path = Paths.get(file.getPath());
                Path pathTo = Paths.get(DirectoryPaths.CONTENTS_FILE_PATH + file.getName());
                if (Files.exists(pathTo)) {
                    Files.delete(pathTo);
                }
                Files.copy(path, pathTo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public ContentMeta getContentMetaObject(String contentMeta) {
        String[] lines = contentMeta.split(System.lineSeparator());
        String doi = lines[1].trim().split("/")[1];
        String subject = lines[2].trim();
        String title = lines[3].trim();
        String author = lines[4].trim();
        return new ContentMeta(doi, subject, title, author);
    }


    @Override
    public void run() {

        int idx = zippedFile.lastIndexOf("/");
        String zipFileName = zippedFile.substring(idx + 1,zippedFile.length()-4);
        UnZip.unZip(zippedFile, DirectoryPaths.UNPROCESSED_FILE_PATH + zipFileName);

        File file = new File(DirectoryPaths.UNPROCESSED_FILE_PATH + zipFileName);

        File[] files = findFiles(file);


        copyFiles(files);

        String contentMeta = TransformationUtil.getXml(DirectoryPaths.CONTENTS_FILE_PATH + files[0].getName(), WebFilesPaths.META_XSL_PATH);

        ContentMeta contentMeta1 = getContentMetaObject(contentMeta);
        DAO contentDAO = new ContentMetaDAO();
        contentDAO.insert(contentMeta1);

        String contentHtml = TransformationUtil.getXml(DirectoryPaths.CONTENTS_FILE_PATH + files[0].getName(), WebFilesPaths.HTML_XSL_PATH);
        File file1 = new File(DirectoryPaths.CONTENTS_FILE_PATH + contentMeta1.getTheDoi() + ".html");
        try {
            PrintWriter printWriter = new PrintWriter(file1);
            printWriter.println(contentHtml);
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DAO unprocessedFileDAO = new UnprocessedFileDAO();
        unprocessedFileDAO.update(zippedFile);
    }
}
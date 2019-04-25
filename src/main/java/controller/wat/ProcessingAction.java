package controller.wat;

import controller.actions.IAction;
import utilities.TransformationUtil;
import utilities.UnZip;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProcessingAction implements IAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();

        switch (method) {
            case "POST":
                doPost(request, response);
                break;
            case "GET":
                doGet(request, response);
                break;
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/FileIsSubmited.jsp");
        requestDispatcher.forward(request, response);

    }

    private void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  UnZip.unZip("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\content\\a.zip","C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\content");
        writeContetXml("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\content\\bhda_42_2\\0198742916688653\\0198742916688653.xml", "C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\web\\test\\parsMeta.xsl");
    }

    private void writeContetXml(String xml, String xsl) throws IOException {
        String string = TransformationUtil.getXml(xml, xsl);
        File file = new File("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\theDois" + "\\a.xml");
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));
        printWriter.write(string);
        printWriter.flush();
        printWriter.close();

        Path path = Paths.get("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\content\\bhda_42_2\\0198742916688653\\0198742916688653.pdf");
        Path pathTo = Paths.get("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\theDois\\a.pdf");
        Files.copy(path, pathTo);
    }


}

package controller.wat;

import controller.actions.IAction;
import utilities.UnZip;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnzipAdmin implements IAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();

        switch (method) {
            case "POST":
                doPost(request,response);
                break;
            case "GET":
                doGet(request,response);
                break;
        }

    }

    private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/FileIsSubmited.jsp");
        requestDispatcher.forward(request, response);

    }

    private void doPost(HttpServletRequest request, HttpServletResponse response) {
        UnZip.unZip("","");
    }
}

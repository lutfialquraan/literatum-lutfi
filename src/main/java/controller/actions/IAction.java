package controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
     default void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
    void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception;

    void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception;

    }

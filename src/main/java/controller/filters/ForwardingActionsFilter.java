package controller.filters;

import controller.servlet.FrontController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardingActionsFilter implements Filter {

    FilterConfig config;
    public void init(FilterConfig filterConfig) throws ServletException {

        this.config = filterConfig;

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        if (url.endsWith("css") || url.endsWith("jsp") || url.endsWith("js") || url.endsWith("html") || url.endsWith("ico") || url.endsWith("jpg")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
            return;
        }
        String action = request.getRequestURI();
        request.setAttribute("action", action);

        FrontController.getRequestDispatcher(config.getServletContext()).forward(request, response);
    }
}

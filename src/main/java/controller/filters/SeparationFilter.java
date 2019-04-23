package controller.filters;

import controller.FrontController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SeparationFilter implements Filter {

    FilterConfig config;


    public void init(FilterConfig filterConfig) throws ServletException {

        this.config = filterConfig;

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        if (url.endsWith("css") || url.endsWith("jsp") || url.endsWith("js") || url.endsWith("html")) {
            return;
        }
        String action = ((HttpServletRequest) servletRequest).getRequestURI();
        servletRequest.setAttribute("action", action);
        FrontController.getRequestDispatcher(config.getServletContext()).forward(servletRequest, servletResponse);


    }
}

package com.rapoo.store.filter;

import com.rapoo.store.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class CheckLoginFilter implements Filter {
    String[] uncheckUri = {"/login.jsp","/login"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Object user = req.getSession().getAttribute("USER_IN_SESSION");
        String uri = req.getRequestURI();
        if(!Arrays.asList(uncheckUri).contains(uri) && user == null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }else{
            filterChain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}

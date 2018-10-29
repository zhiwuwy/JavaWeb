package com.rapoo.store.filter;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这个过滤器是字符编码过滤器,如果本来没有编码,而且可以强制设置编码,就用我的编码
 */
public class CharacterEncodingFilter implements Filter {
    private String encoding;
    private Boolean forceEncoding =false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        forceEncoding = Boolean.valueOf(filterConfig.getInitParameter("force"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(StringUtils.isNotBlank(encoding) && req.getCharacterEncoding() == null && forceEncoding){
            req.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}

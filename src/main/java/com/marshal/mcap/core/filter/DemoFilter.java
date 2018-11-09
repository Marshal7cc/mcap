package com.marshal.mcap.core.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DemoFilter implements Filter {
    /**
     * 容器初始化时
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if(true){
            /**
             * 请求执行前处理，一般对request或session进行处理
             */
            System.out.println("Custom Filter preview handler execute");
            //请求执行
            filterChain.doFilter(servletRequest,servletResponse);
            /**
             * 请求执行后处理，一般对response进行处理
             */
            System.out.println("Custom Filter post handler execute");
        }else{
            response.sendRedirect("/user/login");
        }
    }

    /**
     * web应用关闭
     */
    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }
}

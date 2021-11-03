package com.myannotion;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;

public class PostConstructAnno implements Servlet {


    @PostConstruct
    public void testPostConstruct(){
        System.out.println("======= @PostConstruct annotation=========");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

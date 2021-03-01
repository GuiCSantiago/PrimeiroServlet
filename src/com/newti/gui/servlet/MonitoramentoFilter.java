package com.newti.gui.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/UnicaEntradaServlet")
public class MonitoramentoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Monitoramento");
        long inicio = System.currentTimeMillis();

        String acao = servletRequest.getParameter("acao");

        filterChain.doFilter(servletRequest,servletResponse);

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução ("+ acao +"): " + (fim-inicio));

    }

    @Override
    public void destroy() {
    }
}

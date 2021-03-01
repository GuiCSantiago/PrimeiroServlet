package com.newti.gui.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/UnicaEntradaServlet")
public class AutorizacaoFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) throws ServletException, IOException {

        System.out.println("Autorização");
        HttpServletRequest request = (HttpServletRequest)ServletRequest;
        HttpServletResponse response = (HttpServletResponse)ServletResponse;
        String paramAcao = request.getParameter("acao");
        HttpSession sessao = request.getSession();
        boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuariologado") == null);
        boolean verificaAcaoProtegida = !(paramAcao.equals("LoginForm")||paramAcao.equals("Login"));

        if(verificaAcaoProtegida && usuarioNaoEstaLogado){
            response.sendRedirect("UnicaEntradaServlet?acao=LoginForm");
            return;
        }
        chain.doFilter(request,response);
    }
}

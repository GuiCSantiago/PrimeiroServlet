package com.newti.gui.servlet;

import com.newti.gui.acao.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/UnicaEntradaServlet")
public class ControladorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) throws ServletException, IOException {

        System.out.println("Controlador");
        HttpServletRequest request = (HttpServletRequest)ServletRequest;
        HttpServletResponse response = (HttpServletResponse)ServletResponse;
        String paramAcao = request.getParameter("acao");

        String nome = null;
        String nomeDaClasse = "com.newti.gui.acao." + paramAcao;

        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        }catch(ClassNotFoundException | InstantiationException|IllegalAccessException e){
            throw new ServletException(e);
        }

        String[] tipoEEndereco = nome.split(":");

        if (tipoEEndereco[0].equals("foward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
            rd.forward(request, response);
        } else
            response.sendRedirect(tipoEEndereco[1]);
    }
}

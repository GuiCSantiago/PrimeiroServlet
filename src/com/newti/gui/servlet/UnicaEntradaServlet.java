package com.newti.gui.servlet;

import com.newti.gui.acao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UnicaEntradaServlet", value = "/UnicaEntradaServlet")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        /*
        if (paramAcao.equals("ListarEmpresas")) {

            ListarEmpresas acao = new ListarEmpresas();
            nome = acao.executa(request, response);

        } else if (paramAcao.equals("RemoverEmpresa")) {

            RemoverEmpresa acao = new RemoverEmpresa();
            nome = acao.executa(request, response);

        } else if (paramAcao.equals("MostrarEmpresa")) {

            MostrarEmpresa acao = new MostrarEmpresa();
            nome = acao.executa(request, response);

        } else if (paramAcao.equals("EditarEmpresa")) {

            EditarEmpresa acao = new EditarEmpresa();
            nome = acao.executa(request, response);
        } else if (paramAcao.equals("NovaEmpresa")) {

            NovaEmpresa acao = new NovaEmpresa();
            nome = acao.executa(request, response);
        } else if (paramAcao.equals("NovaEmpresaForm")){
            NovaEmpresaForm acao = new NovaEmpresaForm();
            nome = acao.executa(request, response);
        }
*/
        String[] tipoEEndereco = nome.split(":");

        if (tipoEEndereco[0].equals("foward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
            rd.forward(request, response);
        } else
            response.sendRedirect(tipoEEndereco[1]);
    }
}


package com.newti.gui.acao;

import com.newti.gui.modelo.Banco;
import com.newti.gui.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date dataAbertura = null;
        String nomeEmpresa = request.getParameter("name");
        String paramDataEmpresa = request.getParameter("data");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        try {
            dataAbertura = sdf.parse(paramDataEmpresa);
        }
        catch (ParseException e){
            throw new ServletException(e);
        }

        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setNome(nomeEmpresa);
        novaEmpresa.setDataAbertura(dataAbertura);

        Banco bancoDeDados = new Banco();
        bancoDeDados.adiciona(novaEmpresa);

        return "redirect:UnicaEntradaServlet?acao=ListarEmpresas";
        /*
        //chamar JSP
        RequestDispatcher rd = request.getRequestDispatcher("/ListaEmpresasServlet");
        request.setAttribute("empresa",novaEmpresa.getNome());
        rd.forward(request, response);
        */
    }
}

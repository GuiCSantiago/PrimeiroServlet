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

public class EditarEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Date dataAbertura = null;
        String nomeEmpresa = request.getParameter("name");
        String paramDataEmpresa = request.getParameter("data");
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        Empresa emp = banco.buscaEmpresaPorId(id);
        emp.setNome(nomeEmpresa);
        emp.setDataAbertura(dataAbertura);

        return "redirect:UnicaEntradaServlet?acao=ListarEmpresas";
    }

}

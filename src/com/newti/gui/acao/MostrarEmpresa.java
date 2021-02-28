package com.newti.gui.acao;

import com.newti.gui.modelo.Banco;
import com.newti.gui.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostrarEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        Banco banco = new Banco();
        Empresa emp = banco.buscaEmpresaPorId(id);

        request.setAttribute("empresa",emp);

        return "foward:formAlteraEmpresa.jsp";
    }
}

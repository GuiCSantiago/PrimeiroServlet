package com.newti.gui.acao;

import com.newti.gui.modelo.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoverEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        return "redirect:UnicaEntradaServlet?acao=ListarEmpresas";
    }

}

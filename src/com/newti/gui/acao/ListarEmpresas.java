package com.newti.gui.acao;

import com.newti.gui.modelo.Banco;
import com.newti.gui.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListarEmpresas implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Banco banco = new Banco();
        List<Empresa> lista = banco.getListaEmpresas();

        request.setAttribute("empresas",lista);

        return "foward:listaEmpresas.jsp";
    }
}

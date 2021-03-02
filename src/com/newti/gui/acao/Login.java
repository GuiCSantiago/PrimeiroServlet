package com.newti.gui.acao;

import com.newti.gui.modelo.Banco;
import com.newti.gui.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login,senha);

        if(usuario!=null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuariologado",usuario);
            return "redirect:UnicaEntradaServlet?acao=ListarEmpresas";
        }
        return  "redirect:UnicaEntradaServlet?acao=LoginForm";
    }
}

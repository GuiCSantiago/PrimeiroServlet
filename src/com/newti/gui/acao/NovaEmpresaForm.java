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

public class NovaEmpresaForm implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response){

       return  "foward:formNovaEmpresa.jsp";
    }
}

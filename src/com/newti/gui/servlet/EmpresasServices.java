package com.newti.gui.servlet;

import com.google.gson.Gson;
import com.newti.gui.modelo.Banco;
import com.newti.gui.modelo.Empresa;
import com.thoughtworks.xstream.XStream;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasServices", value = "/EmpresasServices")
public class EmpresasServices extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Empresa> listaEmpresas = new Banco().getListaEmpresas();

        String header = request.getHeader("Accept");

        if(header.endsWith("xml")) {
            XStream xStream = new XStream();
            xStream.alias("Empresa", Empresa.class);
            String xml = xStream.toXML(listaEmpresas);
            response.setContentType("application/xml");
            response.getWriter().println(xml);
        }
        else if(header.endsWith("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(listaEmpresas);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
        else{
            response.setContentType("application/json");
            response.getWriter().println("{'message': 'no content'}");
        }

    }
}

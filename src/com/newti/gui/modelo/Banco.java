package com.newti.gui.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<Empresa> listaEmpresas = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa1 = new Empresa();
        Empresa empresa2 = new Empresa();
        empresa1.setNome("NewTi");
        empresa1.setId(chaveSequencial++);
        empresa2.setNome("Alura");
        empresa2.setId(chaveSequencial++);
        listaEmpresas.add(empresa1);
        listaEmpresas.add(empresa2);
    }


    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void adiciona(Empresa novaEmpresa) {
        novaEmpresa.setId(chaveSequencial++);
        listaEmpresas.add(novaEmpresa);
    }

    public void removeEmpresa(Integer id) {

        Iterator<Empresa> it = listaEmpresas.iterator();

        while (it.hasNext()){
            Empresa emp = it.next();
            if(emp.getId()==id){
                it.remove();
            }
        }
    }

    public Empresa buscaEmpresaPorId(Integer id) {
        for (Empresa emp: listaEmpresas) {
            if(emp.getId() == id){
                return emp;
            }
        }
        return null;
    }
}

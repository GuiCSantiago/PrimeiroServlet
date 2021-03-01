package com.newti.gui.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<Empresa> listaEmpresas = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();
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

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        usuario1.setLogin("Gui");
        usuario2.setLogin("Ricardo");
        usuario1.setSenha("1234");
        usuario2.setSenha("4321");
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
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

    public Usuario existeUsuario(String login, String senha) {
        for (Usuario usuario : listaUsuarios) {
            if(usuario.verificaSeIgual(login, senha))
                return usuario;
        }
        return null;
    }
}

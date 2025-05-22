package br.edu.cs.poo.ac.seguro.daos;

import br.edu.cs.poo.ac.seguro.entidades.Segurado;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public abstract class SeguradoDAO extends DAOGenerico {

    public SeguradoDAO(Class<?> classe) {
        this.cadastro = new CadastroObjetos(classe);
    }

    public Segurado buscar(String numero) {
        return (Segurado) cadastro.buscar(numero);
    }

    public boolean incluir(Segurado segurado, String chave) {
        if (buscar(chave) != null) return false;
        cadastro.incluir(segurado, chave);
        return true;
    }

    public boolean alterar(Segurado segurado, String chave) {
        if (buscar(chave) == null) return false;
        cadastro.alterar(segurado, chave);
        return true;
    }

    public boolean excluir(String chave) {
        if (buscar(chave) == null) return false;
        cadastro.excluir(chave);
        return true;
    }
}
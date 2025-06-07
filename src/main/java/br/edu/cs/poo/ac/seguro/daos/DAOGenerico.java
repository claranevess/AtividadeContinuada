package br.edu.cs.poo.ac.seguro.daos;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.edu.cs.poo.ac.seguro.entidades.Registro;
import java.io.Serializable;

public abstract class DAOGenerico<T extends Registro> {

    private CadastroObjetos cadastro;

    public DAOGenerico() {
        this.cadastro = new CadastroObjetos(getClasseEntidade());
    }

    public abstract Class<T> getClasseEntidade();

    public boolean incluir(T entidade) {
        if (entidade == null || entidade.getIdUnico() == null) {
            return false;
        }
        if (buscar(entidade.getIdUnico()) != null) {
            return false;
        }
        cadastro.incluir(entidade, entidade.getIdUnico());
        return true;
    }

    public boolean alterar(T entidade) {
        if (entidade == null || entidade.getIdUnico() == null) {
            return false;
        }
        if (buscar(entidade.getIdUnico()) == null) {
            return false;
        }
        cadastro.alterar(entidade, entidade.getIdUnico());
        return true;
    }

    public boolean excluir(String chave) {
        if (chave == null || buscar(chave) == null) {
            return false;
        }
        cadastro.excluir(chave);
        return true;
    }

    @SuppressWarnings("unchecked")
    public T buscar(String chave) {
        if (chave == null) {
            return null;
        }
        return (T) cadastro.buscar(chave);
    }

    @SuppressWarnings("unchecked")
    public T[] buscarTodos() {
        Serializable[] objsSer = cadastro.buscarTodos();
        T[] registros = (T[]) new Registro[objsSer.length];
        for (int i = 0; i < objsSer.length; i++) {
            registros[i] = (T) objsSer[i];
        }
        return registros;
    }
}

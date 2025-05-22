package br.edu.cs.poo.ac.seguro.daos;

import br.edu.cs.poo.ac.seguro.entidades.SeguradoEmpresa;

public class SeguradoEmpresaDAO extends SeguradoDAO {

    public SeguradoEmpresaDAO() {
        super(SeguradoEmpresa.class);
    }

    public SeguradoEmpresa buscar(String cnpj) {
        return (SeguradoEmpresa) super.buscar(cnpj);
    }

    public boolean incluir(SeguradoEmpresa segurado) {
        return super.incluir(segurado, segurado.getCnpj());
    }

    public boolean alterar(SeguradoEmpresa segurado) {
        return super.alterar(segurado, segurado.getCnpj());
    }

    public boolean excluir(String cnpj) {
        return super.excluir(cnpj);
    }
}
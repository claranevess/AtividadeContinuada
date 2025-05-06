package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.daos.SeguradoEmpresaDAO;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoEmpresa;

public class SeguradoEmpresaMediator {
    private static SeguradoEmpresaMediator instancia;
    private SeguradoEmpresaDAO dao = new SeguradoEmpresaDAO();
    private SeguradoMediator seguradoMediator;

    private SeguradoEmpresaMediator() {}

    public static SeguradoEmpresaMediator getInstancia() {
        if (instancia == null) {
            instancia = new SeguradoEmpresaMediator();
        }
        return instancia;
    }

    public String validarCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()) {
            return "CNPJ inválido.";
        }
        return null;
    }

    public String validarFaturamento(double faturamento) {
        if (faturamento < 0) {
            return "Faturamento não pode ser negativo.";
        }
        return null;
    }

    public String validarSeguradoEmpresa(SeguradoEmpresa seg) {
        if (seg == null) return "SeguradoEmpresa nulo.";

        String cnpjErro = validarCnpj(seg.getCnpj());
        if (cnpjErro != null) return cnpjErro;

        String faturamentoErro = validarFaturamento(seg.getFaturamento());
        if (faturamentoErro != null) return faturamentoErro;

        return null;
    }

    public String incluirSeguradoEmpresa(SeguradoEmpresa seg) {
        String msg = validarSeguradoEmpresa(seg);
        if (msg != null) return msg;

        dao.incluir(seg);
        return null;
    }

    public String alterarSeguradoEmpresa(SeguradoEmpresa seg) {
        String msg = validarSeguradoEmpresa(seg);
        if (msg != null) return msg;

        dao.alterar(seg);
        return null;
    }

    public String excluirSeguradoEmpresa(String cnpj) {
        String erro = validarCnpj(cnpj);
        if (erro != null) return erro;

        dao.excluir(cnpj);
        return null;
    }

    public SeguradoEmpresa buscarSeguradoEmpresa(String cnpj) {
        return dao.buscar(cnpj);
    }
}


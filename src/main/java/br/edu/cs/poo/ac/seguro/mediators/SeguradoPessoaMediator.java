package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.daos.SeguradoPessoaDAO;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoPessoa;

public class SeguradoPessoaMediator {
    private static SeguradoPessoaMediator instancia;
    private SeguradoPessoaDAO dao = new SeguradoPessoaDAO();

    private SeguradoPessoaMediator() {}

    public static SeguradoPessoaMediator getInstancia() {
        if (instancia == null) {
            instancia = new SeguradoPessoaMediator();
        }
        return instancia;
    }

    public String validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return "CPF inválido.";
        }
        return null;
    }

    public String validarRenda(double renda) {
        if (renda < 0) {
            return "Renda não pode ser negativa.";
        }
        return null;
    }

    public String validarSeguradoPessoa(SeguradoPessoa seg) {
        if (seg == null) return "SeguradoPessoa nulo.";

        String cpfErro = validarCpf(seg.getCpf());
        if (cpfErro != null) return cpfErro;

        String rendaErro = validarRenda(seg.getRenda());
        if (rendaErro != null) return rendaErro;

        return null;
    }

    public String incluirSeguradoPessoa(SeguradoPessoa seg) {
        String msg = validarSeguradoPessoa(seg);
        if (msg != null) return msg;

        boolean sucesso = dao.incluir(seg);
        return sucesso ? null : "Já existe um segurado com esse CPF.";
    }

    public String alterarSeguradoPessoa(SeguradoPessoa seg) {
        String msg = validarSeguradoPessoa(seg);
        if (msg != null) return msg;

        boolean sucesso = dao.alterar(seg);
        return sucesso ? null : "Segurado não encontrado para alteração.";
    }

    public String excluirSeguradoPessoa(String cpf) {
        String erro = validarCpf(cpf);
        if (erro != null) return erro;

        boolean sucesso = dao.excluir(cpf);
        return sucesso ? null : "Segurado não encontrado para exclusão.";
    }

    public SeguradoPessoa buscarSeguradoPessoa(String cpf) {
        return dao.buscar(cpf);
    }
}



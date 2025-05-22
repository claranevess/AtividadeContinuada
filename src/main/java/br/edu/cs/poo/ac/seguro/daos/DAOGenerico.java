package br.edu.cs.poo.ac.seguro.daos;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.edu.cs.poo.ac.seguro.entidades.Registro;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;

public abstract class DAOGenerico<T extends Registro> {
	private CadastroObjetos cadastro;



	public abstract Class getClasseEntidade();

	public DAOGenerico(){

	}

	public Sinistro[] buscarTodos() {
		Object[] objetos = cadastro.buscarTodos();
		Sinistro[] sinistros = new Sinistro[objetos.length];
		for (int i = 0; i < objetos.length; i++) {
			sinistros[i] = (Sinistro) objetos[i];
		}
		return sinistros;
	}
}

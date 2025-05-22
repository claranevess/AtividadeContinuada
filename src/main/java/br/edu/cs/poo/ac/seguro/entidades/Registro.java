package br.edu.cs.poo.ac.seguro.entidades;

import java.io.Serializable;

public interface Registro extends Serializable {
    static final long serialVersionUID = 1L;

    String getIdUnico();
}

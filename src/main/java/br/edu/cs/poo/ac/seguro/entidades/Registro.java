package br.edu.cs.poo.ac.seguro.entidades;

import java.io.Serializable;

public abstract class Registro implements Serializable {
    static final long serialVersionUID = 1L;
    public abstract String getIdUnico();
}

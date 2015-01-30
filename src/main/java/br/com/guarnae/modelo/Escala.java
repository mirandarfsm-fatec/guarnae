package br.com.guarnae.modelo;

import java.util.List;

public class Escala {

	private String nome;
	private List<Militar> militares;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Militar> getMilitares() {
		return militares;
	}

	public void setMilitares(List<Militar> militares) {
		this.militares = militares;
	}
	
	public int quantidadeMilitar(){
		return militares.size();
	}

}

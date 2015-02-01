package br.com.guarnae.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "militar")
public class Militar implements Comparable<Militar> {

	private Long id;
	private String nome;
	private List<Date> pretas;
	private List<Date> vermelhas;

	@Id
	@GeneratedValue
	@Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nome",unique=true,nullable=false)
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ElementCollection(targetClass=Date.class,fetch=FetchType.LAZY)
	public List<Date> getPretas() {
		return pretas;
	}

	public void setPretas(List<Date> pretas) {
		this.pretas = pretas;
	}

	@ElementCollection(targetClass=Date.class)
	public List<Date> getVermelhas() {
		return vermelhas;
	}

	public void setVermelhas(List<Date> vermelhas) {
		this.vermelhas = vermelhas;
	}

	public int quantidadePreta() {
		return this.pretas.size();
	}

	public int quantidadeVermelha() {
		return this.vermelhas.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pretas == null) ? 0 : pretas.hashCode());
		result = prime * result
				+ ((vermelhas == null) ? 0 : vermelhas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Militar other = (Militar) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pretas == null) {
			if (other.pretas != null)
				return false;
		} else if (!pretas.equals(other.pretas))
			return false;
		if (vermelhas == null) {
			if (other.vermelhas != null)
				return false;
		} else if (!vermelhas.equals(other.vermelhas))
			return false;
		return true;
	}

	public int compareTo(Militar m) {
		return this.quantidadePreta() < m.quantidadePreta() ? -1 : (this
				.quantidadePreta() < m.quantidadePreta() ? +1 : 0);

	}

}

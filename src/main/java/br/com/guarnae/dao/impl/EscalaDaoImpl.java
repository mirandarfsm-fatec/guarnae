package br.com.guarnae.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.guarnae.dao.EscalaDao;
import br.com.guarnae.modelo.Escala;
import br.com.guarnae.modelo.Militar;

@Repository
public class EscalaDaoImpl implements EscalaDao {

	private List<Escala> escalas = new LinkedList<Escala>();
	
	public Escala getEscala(Escala escala) {
		for (Escala e : this.escalas) {
			if(e.getNome().equals(escala.getNome()));
				return e;
		}
		return null;
	}

	public List<Escala> findAll() {
		return this.escalas;
	}

	public void save(Escala escala) {
		this.escalas.add(escala);
	}

	public void update(Escala escala) {
		Escala e = getEscala(escala);
		e.setMilitares(escala.getMilitares());
	}

	public void remove(Escala escala) {
		this.escalas.remove(escala);
	}
	
	public void addMilitar(Escala escala, Militar militar){
		Escala e = getEscala(escala);
		e.getMilitares().add(militar);
	}
	
	public void removeMilitar(Escala escala, Militar militar){
		Escala e = getEscala(escala);
		e.getMilitares().remove(militar);
	}
}

package br.com.guarnae.dao.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.guarnae.dao.MilitarDao;
import br.com.guarnae.modelo.Militar;

@Repository
public class MilitarDaoImpl implements MilitarDao {

	private List<Militar> militares = new LinkedList<Militar>();

	public Militar getMilitar(Militar militar) {
		for (Militar m : this.militares) {
			if (m.getNome().equals(militar.getNome()))
				;
			return m;
		}
		return null;
	}

	public List<Militar> findAll() {
		return this.militares;
	}

	public void save(Militar militar) {
		this.militares.add(militar);
	}

	public void update(Militar militar) {
		Militar m = getMilitar(militar);
		m.setPretas(militar.getPretas());
		m.setPretas(militar.getVermelhas());
	}

	public void remove(Militar militar) {
		this.militares.remove(militar);
	}

	public void addPreta(Militar militar, Date data) {
		Militar m = getMilitar(militar);
		m.getPretas().add(data);
	}

	public void addVermelha(Militar militar, Date data) {
		Militar m = getMilitar(militar);
		m.getPretas().add(data);
	}

}

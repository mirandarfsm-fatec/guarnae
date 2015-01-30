package br.com.guarnae.dao;

import java.util.Date;
import java.util.List;

import br.com.guarnae.modelo.Militar;

public interface MilitarDao {

	Militar getMilitar(Militar militar);

	List<Militar> findAll();

	void save(Militar militar);

	void update(Militar militar);

	void remove(Militar militar);
	
	void addPreta(Militar militar, Date data);
	
	void addVermelha(Militar militar, Date data);
}

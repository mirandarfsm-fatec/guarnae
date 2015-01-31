package br.com.guarnae.dao;

import java.util.List;

import br.com.guarnae.modelo.Escala;

public interface EscalaDao {

	Escala getById(final Long id);

	List<Escala> findAll();

	void save(Escala escala);

	void update(Escala escala);

	void remove(Escala escala);

	void removeById(final Long id);

}

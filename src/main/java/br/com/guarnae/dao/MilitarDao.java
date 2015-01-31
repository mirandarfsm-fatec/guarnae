package br.com.guarnae.dao;

import java.util.List;

import br.com.guarnae.modelo.Militar;

public interface MilitarDao {

	Militar getById(final Long id);

	List<Militar> findAll();

	void save(Militar militar);

	void update(Militar militar);

	void remove(Militar militar);

	void removeById(final Long id);

}

package br.com.guarnae.servico;

import java.util.List;

import br.com.guarnae.modelo.Militar;

public interface MilitarServico {

	Militar getById(final Long id);

	List<Militar> findAll();

	void save(Militar militar);

	void update(Militar militar);

	void remove(Militar militar);

	void removeById(final Long id);

	double escalaPretaPorMilitar(int quantidade);

	double escalaVermelhaPorMilitar(int quantidade);

	double escalaRoxaPorMilitar(int quantidade);

	double escalaPorMilitar(int quantidade);
}

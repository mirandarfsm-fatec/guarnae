package br.com.guarnae.servico;

import java.util.Date;
import java.util.List;

import br.com.guarnae.modelo.Escala;

public interface EscalaServico {

	Escala getById(final Long id);

	List<Escala> findAll();

	void save(Escala escala);

	void update(Escala escala);

	void remove(Escala escala);

	void removeById(final Long id);

	void escalarPreta(List<Date> pretas, Escala escala);

	void escalarVermelha(List<Date> pretas, Escala escala);
}

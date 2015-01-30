package br.com.guarnae.servico;

import java.util.Date;
import java.util.List;

import br.com.guarnae.modelo.Escala;
import br.com.guarnae.modelo.Militar;

public interface EscalaServico {

	Escala getEscala(Escala escala);

	List<Escala> findAll();

	void save(Escala escala);

	void update(Escala escala);

	void remove(Escala escala);
	
	void addMilitar(Escala escala, Militar militar);

	void removeMilitar(Escala escala, Militar militar);
	
	void escalarPreta(List<Date> pretas, Escala escala);
	
	void escalarVermelha(List<Date> pretas, Escala escala);
}

package br.com.guarnae.servico;

import java.util.Date;
import java.util.List;

import br.com.guarnae.modelo.Militar;

public interface MilitarServico {

	Militar getMilitar(Militar militar);

	List<Militar> findAll();

	void save(Militar militar);

	void update(Militar militar);

	void remove(Militar militar);
	
	void addPreta(Militar militar, Date data);
	
	void addVermelha(Militar militar, Date data);

	double escalaPretaPorMilitar(int quantidade);

	double escalaVermelhaPorMilitar(int quantidade);

	double escalaRoxaPorMilitar(int quantidade);

	double escalaPorMilitar(int quantidade);
}

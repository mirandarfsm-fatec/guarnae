package br.com.guarnae.servico.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guarnae.dao.EscalaDao;
import br.com.guarnae.modelo.Escala;
import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.EscalaServico;

@Service
public class EscalaServicoImpl implements EscalaServico {

	@Autowired
	EscalaDao dao;

	public Escala getEscala(Escala escala) {
		return dao.getEscala(escala);
	}

	public List<Escala> findAll() {
		return dao.findAll();
	}

	public void save(Escala escala) {
		dao.save(escala);
	}

	public void update(Escala escala) {
		dao.update(escala);
	}

	public void remove(Escala escala) {
		dao.remove(escala);
	}

	public void addMilitar(Escala escala, Militar militar) {
		dao.addMilitar(escala, militar);
	}

	public void removeMilitar(Escala escala, Militar militar) {
		dao.removeMilitar(escala, militar);
	}

	public void escalarPreta(List<Date> pretas, Escala escala) {
		Collections.sort(escala.getMilitares(), new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				Militar m1 = (Militar) o1;
				Militar m2 = (Militar) o2;
				return m1.quantidadePreta() < m2.quantidadePreta() ? -1 : (m1
						.quantidadePreta() < m2.quantidadePreta() ? +1 : 0);

			}
		});
		int i = 0;
		for (Date p : pretas) {
			escala.getMilitares().get(i).getPretas().add(p);
			i++;
		}
	}

	public void escalarVermelha(List<Date> vermelhas, Escala escala) {
		Collections.sort(escala.getMilitares(), new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				Militar m1 = (Militar) o1;
				Militar m2 = (Militar) o2;
				return m1.quantidadeVermelha() < m2.quantidadeVermelha() ? -1
						: (m1.quantidadeVermelha() < m2.quantidadeVermelha() ? +1
								: 0);

			}
		});
		int i = 0;
		for (Date v : vermelhas) {
			escala.getMilitares().get(i).getPretas().add(v);
			i++;
		}
	}

}

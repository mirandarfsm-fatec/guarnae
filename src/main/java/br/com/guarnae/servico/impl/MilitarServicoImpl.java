package br.com.guarnae.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guarnae.dao.MilitarDao;
import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.MilitarServico;

@Service
@Transactional
public class MilitarServicoImpl implements MilitarServico {

	@Autowired
	private MilitarDao dao;

	public Militar getById(final Long id) {
		return dao.getById(id);
	}

	public List<Militar> findAll() {
		return dao.findAll();
	}

	public void save(Militar militar) {
		dao.save(militar);
	}

	public void update(Militar militar) {
		dao.update(militar);
	}

	public void remove(Militar militar) {
		dao.remove(militar);
	}

	public void removeById(final Long id) {
		dao.removeById(id);
	}

	public double escalaPretaPorMilitar(int quantidade) {
		return 261 / quantidade;
	}

	public double escalaVermelhaPorMilitar(int quantidade) {
		return 88 / quantidade;
	}

	public double escalaRoxaPorMilitar(int quantidade) {
		return 16 / quantidade;
	}

	public double escalaPorMilitar(int quantidade) {
		return 365 / quantidade;
	}

}

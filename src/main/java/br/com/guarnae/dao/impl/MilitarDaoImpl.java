package br.com.guarnae.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.guarnae.dao.MilitarDao;
import br.com.guarnae.modelo.Militar;

@Repository
public class MilitarDaoImpl implements MilitarDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Militar getById(final Long id) {
		return entityManager.find(Militar.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Militar> findAll() {
		return entityManager.createQuery("FROM " + Militar.class.getName())
				.getResultList();
	}

	public void save(Militar militar) {
		entityManager.persist(militar);
	}

	public void update(Militar militar) {
		entityManager.merge(militar);
	}

	public void remove(Militar militar) {
		militar = getById(militar.getId());
		entityManager.remove(militar);
	}

	public void removeById(final Long id) {
		Militar militar = getById(id);
		entityManager.remove(militar);
	}

}

package br.com.guarnae.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.guarnae.dao.EscalaDao;
import br.com.guarnae.modelo.Escala;

@Repository
public class EscalaDaoImpl implements EscalaDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Escala getById(Long id) {
		return entityManager.find(Escala.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Escala> findAll() {
		return entityManager.createQuery("FROM " + Escala.class.getName())
				.getResultList();
	}

	public void save(Escala escala) {
		entityManager.persist(escala);
	}

	public void update(Escala escala) {
		entityManager.merge(escala);
	}

	public void remove(Escala escala) {
		escala = getById(escala.getId());
		entityManager.remove(escala);
	}

	public void removeById(Long id) {
		Escala escala = getById(id);
		entityManager.remove(escala);
	}

}

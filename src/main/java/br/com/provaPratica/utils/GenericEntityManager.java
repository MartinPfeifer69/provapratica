package br.com.provaPratica.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericEntityManager {
	EntityManagerFactory factory;
	EntityManager manager;
	private String persistenceUnitName = "UnitApp";

	public GenericEntityManager() {
		this.factory = Persistence
				.createEntityManagerFactory(this.persistenceUnitName);
		this.manager = factory.createEntityManager();
	}

	public void insert(Object dados) {
		try {
			begin();
			this.manager.persist(dados);
			commit();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Object dados, Integer id) {
		begin();
		dados = this.manager.find(dados.getClass(), id);
		this.manager.remove(dados);
		commit();
		close();
	}

	public Object find(Object tipo, Integer id) {
		begin();
		Object dados = this.manager.find(tipo.getClass(), id);
		close();
		return dados;
	}

	public void alter(Object dados) {
		begin();

		merge(dados);

		commit();
		close();
	}

	public void begin() {
		this.manager.getTransaction().begin();
	}

	public void commit() {
		this.manager.getTransaction().commit();
	}

	public void close() {
		this.manager.close();
		;
	}

	public void merge(Object registro) {
		this.manager.merge(registro);
	}

	public EntityManager getManager() {
		return manager;
	}
}

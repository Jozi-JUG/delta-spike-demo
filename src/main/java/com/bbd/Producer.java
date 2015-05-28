package com.bbd;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class Producer {

	EntityManagerFactory emf;

	@Produces
	@Default
	@RequestScoped
	public EntityManager create() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("student");
		}
		
		return this.emf.createEntityManager();
	}

	public void dispose(@Disposes @Default EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}
}

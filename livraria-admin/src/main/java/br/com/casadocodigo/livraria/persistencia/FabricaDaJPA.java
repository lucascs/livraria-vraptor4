package br.com.casadocodigo.livraria.persistencia;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

public class FabricaDaJPA {

	@PersistenceContext
	private EntityManager manager;
	
	@Inject
	private Logger logger;
	
	@PostConstruct
	public void inicia() {
		logger.info("Hooooooooo");
	}
	
	@Produces
	public EntityManager getEntityManager() {
		logger.info("Haaaa");
		return manager;
	}
}

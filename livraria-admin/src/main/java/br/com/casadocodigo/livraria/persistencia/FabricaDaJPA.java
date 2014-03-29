package br.com.casadocodigo.livraria.persistencia;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FabricaDaJPA {
	@PersistenceContext
	private EntityManager manager;

	@Produces
	public EntityManager getManager() {
		return manager;
	}	
}

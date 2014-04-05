package br.com.casadocodigo.livraria.persistencia;

import java.net.URI;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.casadocodigo.livraria.modelo.Arquivo;
import br.com.casadocodigo.livraria.modelo.Diretorio;

@Transactional
public class DiretorioNoBD implements Diretorio {
	private EntityManager manager;

	@Inject
	public DiretorioNoBD(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	DiretorioNoBD() {
	}
	
	@Override
	public URI grava(Arquivo arquivo) {
		manager.persist(arquivo);

		return URI.create("bd://" + arquivo.getId());
	}

	@Override
	public Arquivo recupera(URI chave) {
		if (chave == null)
			return null;

		// scheme é o protocolo. No caso de bd:// é o bd
		if (!chave.getScheme().equals("bd")) {
			throw new IllegalArgumentException(chave
					+ " não é uma URI de banco de dados");
		}

		// authority é o que vem depois do bd://
		Long id = Long.valueOf(chave.getAuthority());
		return manager.find(Arquivo.class, id);
	}
}

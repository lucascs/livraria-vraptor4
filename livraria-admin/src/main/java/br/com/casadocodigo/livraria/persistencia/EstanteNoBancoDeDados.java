package br.com.casadocodigo.livraria.persistencia;

import java.util.List;

import javax.inject.Inject;

import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

public class EstanteNoBancoDeDados implements Estante {

	private final LivroDAO dao;

	@Inject
	public EstanteNoBancoDeDados(LivroDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * @deprecated para o CDI
	 */
	EstanteNoBancoDeDados() { this(null); }
	
	@Override
	public void guarda(Livro livro) {
		this.dao.adiciona(livro);
	}

	@Override
	public List<Livro> todosOsLivros() {
		return this.dao.todos();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		return this.dao.buscaPorIsbn(isbn);
	}

}

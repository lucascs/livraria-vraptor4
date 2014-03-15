package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Controller
public class LivrosController {

	private Estante estante;

	@Inject
	public LivrosController(Estante estante) {
		this.estante = estante;
	}
	/**
	 * @deprecated Apenas para o CDI.
	 */
	LivrosController() {
		// TODO Auto-generated constructor stub
	}
	
	public void formulario() {
	}

	public List<Livro> lista(Result result) {
		result.include("baz", estante.todosOsLivros());
		return estante.todosOsLivros();
	}

	public void salva(Livro livro) {
		estante.guarda(livro);
	}

	public void edita(String isbn, Result result) {
	    Livro livroEncontrado = estante.buscaPorIsbn(isbn);
	    result.include(livroEncontrado);

	    result.of(this).formulario();
	}
}

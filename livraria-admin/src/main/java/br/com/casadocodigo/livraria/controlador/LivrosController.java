package br.com.casadocodigo.livraria.controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Controller
public class LivrosController {

	private Estante estante;
	private Result result;
	private Validator validator;

	@Inject
	public LivrosController(Estante estante, Result result, Validator validator) {
		this.estante = estante;
		this.result = result;
		this.validator = validator;
	}

	/**
	 * @deprecated Apenas para o CDI.
	 */
	LivrosController() {
		// TODO Auto-generated constructor stub
	}

	public void formulario() {
	}

	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	public void salva(Livro livro) {
		if (livro.getTitulo() == null) {
			validator.add(new SimpleMessage("titulo", "título é obrigatório"));
		}
		if (livro.getPreco() == null
				|| livro.getPreco().compareTo(BigDecimal.ZERO) < 0) {
			validator.add(new SimpleMessage("preco",
					"preço é obrigatório e deve ser positivo"));
		}
		
		validator.onErrorRedirectTo(this).formulario();
		
		estante.guarda(livro);
		result.redirectTo(this).lista();
	}

	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);

			result.of(this).formulario();
		}
	}
}

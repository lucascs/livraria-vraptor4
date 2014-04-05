package br.com.casadocodigo.livraria.controlador;

import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.ByteArrayDownload;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;
import br.com.casadocodigo.livraria.modelo.Arquivo;
import br.com.casadocodigo.livraria.modelo.Diretorio;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

import com.google.common.io.ByteStreams;

@Controller
public class LivrosController {

	private Estante estante;
	private Result result;
	private Validator validator;
	private Diretorio imagens;

	@Inject
	public LivrosController(Estante estante, Diretorio imagens, Result result,
			Validator validator) {
		this.estante = estante;
		this.result = result;
		this.validator = validator;
		this.imagens = imagens;
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

	@Transactional
	public void salva(@Valid Livro livro, UploadedFile capa) throws IOException {
		validator.onErrorRedirectTo(this).formulario();

		if (capa != null) {
			URI imagemCapa = imagens.grava(new Arquivo(capa.getFileName(),
					ByteStreams.toByteArray(capa.getFile()), capa
							.getContentType(), Calendar.getInstance()));

			livro.setCapa(imagemCapa);
		}
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

	@Get("/livros/{isbn}/capa")
	public Download capa(String isbn) {
		Livro livro = estante.buscaPorIsbn(isbn);

		Arquivo capa = imagens.recupera(livro.getCapa());

		if (capa == null) {
			result.notFound();
			return null;
		}

		return new ByteArrayDownload(capa.getConteudo(), capa.getContentType(),
				capa.getNome());
	}
}

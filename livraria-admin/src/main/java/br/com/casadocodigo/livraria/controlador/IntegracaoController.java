package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Controller
public class IntegracaoController {

  private Estante estante;
  private Result result;

  @Inject
  public IntegracaoController(Estante estante, Result result) {
    this.estante = estante;
    this.result = result;
  }
  @Deprecated IntegracaoController() {}

  public void listaLivros() {
    List<Livro> livros = estante.todosOsLivros();

    result.use(Results.xml()).from(livros, "livros").serialize();
  }
}

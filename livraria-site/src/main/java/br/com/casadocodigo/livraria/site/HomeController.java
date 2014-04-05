package br.com.casadocodigo.livraria.site;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.site.modelo.Acervo;

@Controller
public class HomeController {

  private Acervo acervo;
  private Result result;

  @Inject
  public HomeController(Acervo acervo, Result result) {
    this.acervo = acervo;
    this.result = result;
  }
  @Deprecated HomeController() {}

  public void inicio() {
    this.result.include("livros", acervo.todosOsLivros());
  }

}

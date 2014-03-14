package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;
import br.com.casadocodigo.livraria.persistencia.UmaEstanteQualquer;

@Controller
public class LivrosController {

	public void formulario() {}
	
	public List<Livro> lista() {
		Estante estante = new UmaEstanteQualquer();
		return estante.todosOsLivros();
	}
	
}

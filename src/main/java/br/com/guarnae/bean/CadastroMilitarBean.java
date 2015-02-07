package br.com.guarnae.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.MilitarServico;

@Controller
@Scope("session")
public class CadastroMilitarBean {

	private Militar militar;
	private List<Militar> militares;

	@Autowired
	private MilitarServico servico;

	@PostConstruct
	private void init() {
		militares = servico.findAll();
		// LayoutIndexManager.atualizarIndice(1);
	}

	public String novo() {
		militar = new Militar();
		return "/pages/militar/cadastro-militar-formulario.xhtml";
	}

	public String salvar() {
		servico.save(militar);
		militares = servico.findAll();
		return "/pages/militar/cadastrar-militar-lista.xhtml";
	}

	public String editar() {
		militar = servico.getById(militar.getId());
		return "/pages/militar/cadastrar-militar-formulario.xhtml";
	}

	public String cancelar() {
		return "/pages/militar/cadastrar-militar-lista.xhtml";
	}

	public void excluir() {
		servico.remove(militar);
		militares = servico.findAll();
	}

	public Militar getMilitar() {
		return militar;
	}

	public void setMilitar(Militar militar) {
		this.militar = militar;
	}

	public List<Militar> getMilitares() {
		return militares;
	}

	public void setMilitares(List<Militar> militares) {
		this.militares = militares;
	}

}

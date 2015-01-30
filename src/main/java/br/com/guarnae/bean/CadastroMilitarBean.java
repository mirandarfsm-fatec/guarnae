package br.com.guarnae.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.MilitarServico;

@Controller
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
		militar.setPretas(new ArrayList<Date>());
		militar.setVermelhas(new ArrayList<Date>());
		servico.save(militar);
		militares = servico.findAll();
		return "/pages/militar/cadastrar-militar-lista.xhtml";
	}

	public String editar() {
		militar = servico.getMilitar(militar);
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

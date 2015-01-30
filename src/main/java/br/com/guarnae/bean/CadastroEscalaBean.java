package br.com.guarnae.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.guarnae.modelo.Escala;
import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.EscalaServico;

@Controller
public class CadastroEscalaBean {

	private Escala escala;
	private List<Escala> escalas;

	@Autowired
	private EscalaServico servico;

	@PostConstruct
	private void init() {
		escalas = servico.findAll();
		// LayoutIndexManager.atualizarIndice(1);
	}

	public String novo() {
		escala = new Escala();
		return "/pages/cadastro-escala-formulario.xhtml";
	}

	public String salvar() {
		escala.setMilitares(new ArrayList<Militar>());
		servico.save(escala);
		escalas = servico.findAll();
		return "/pages/cadastrar-escala-lista.xhtml";
	}

	public String editar() {
		escala = servico.getEscala(escala);
		return "/pages/cadastrar-escala-formulario.xhtml";
	}

	public String cancelar() {
		return "/pages/cadastrar-escala-lista.xhtml";
	}

	public void excluir() {
		servico.remove(escala);
		escalas = servico.findAll();
	}

	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public List<Escala> getEscalas() {
		return escalas;
	}

	public void setEscalas(List<Escala> escalas) {
		this.escalas = escalas;
	}

}

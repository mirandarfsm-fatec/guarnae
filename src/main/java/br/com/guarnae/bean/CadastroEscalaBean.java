package br.com.guarnae.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.guarnae.modelo.Escala;
import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.EscalaServico;
import br.com.guarnae.servico.MilitarServico;

@Controller
@Scope("session")
public class CadastroEscalaBean {

	private Escala escala;
	private List<Escala> escalas;
	private List<Militar> militares;

	@Autowired
	private EscalaServico escalaServico;

	@Autowired
	private MilitarServico militarServico;
	
	@PostConstruct
	private void init() {
		escalas = escalaServico.findAll();
	}

	public String novo() {
		escala = new Escala();
		militares = militarServico.findAll();
		return "/pages/escala/cadastro-escala-formulario.xhtml";
	}

	public String salvar() {
		//System.out.println(escala.getMilitares().get(0).getNome().toString());
		escalaServico.save(escala);
		escalas = escalaServico.findAll();
		return "/pages/escala/cadastrar-escala-lista.xhtml";
	}

	public String editar() {
		escala = escalaServico.getById(escala.getId());
		return "/pages/escala/cadastrar-escala-formulario.xhtml";
	}

	public String cancelar() {
		return "/pages/escala/cadastrar-escala-lista.xhtml";
	}

	public void excluir() {
		escalaServico.remove(escala);
		escalas = escalaServico.findAll();
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

	public List<Militar> getMilitares() {
		return militares;
	}

	public void setMilitares(List<Militar> militares) {
		this.militares = militares;
	}

}
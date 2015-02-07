package br.com.guarnae.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.guarnae.modelo.Escala;
import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.EscalaServico;

@Controller
@Scope("session")
public class EscalaMilitarBean {

	private Escala escala;
	private List<Escala> escalas;
	private List<Date> datas;

	@Autowired
	private EscalaServico escalaServico;

	@PostConstruct
	private void init() {
		escalas = escalaServico.findAll();
		datas = new ArrayList<Date>();
		datas.add(new Date());
	}
	
	public String cadastrar() {
		escalaServico.escalarPreta(datas, escala);
		for (Militar m: escala.getMilitares()) {
			message("Militar: " + m.getNome() + "Data: " + m.getPretas());
		}
		return "";
	}
	
	public void cancelar() {
		
	}
	
	public void adicionaData() {
		datas.add(new Date());
	}
	
	public void adicionaData(Object data) {
		datas.remove((Date)data);
	}
	
	private void message(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg, ""));
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

	public List<Date> getDatas() {
		return datas;
	}

	public void setDatas(List<Date> datas) {
		this.datas = datas;
	}
	
	
	
}

package br.com.guarnae.bean;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.guarnae.modelo.Militar;
import br.com.guarnae.servico.MilitarServico;

@Controller
public class MilitarBean {

	private Militar militar;
	private int quantidade;

	@Autowired
	private MilitarServico servico;

	@PostConstruct
	private void init() {
		militar = new Militar();
		militar.setPretas(new ArrayList<Date>());
		militar.setVermelhas(new ArrayList<Date>());
	}

	public String cadastrar() {
		message("Pretas:" + militar.getPretas().size() + " / "
				+ servico.escalaPretaPorMilitar(quantidade));
		message("Vermelhas:" + militar.getVermelhas().size() + " / "
				+ servico.escalaVermelhaPorMilitar(quantidade));
		int total = militar.getPretas().size() + militar.getVermelhas().size();
		message("Total:" + total + " / " + servico.escalaPorMilitar(quantidade));
		return "";
	}

	private void message(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg, ""));
	}

	public void adicionaPreta() {
		militar.getPretas().add(new Date());
	}

	public void adicionaVermelha() {
		militar.getVermelhas().add(new Date());
	}
	
	public void removePreta(Object object) {
		militar.getPretas().remove((Date) object);
	}
	
	public void removeVermelha(Object object) {
		militar.getVermelhas().remove((Date) object);
	}

	public Militar getMilitar() {
		return militar;
	}

	public void setMilitar(Militar militar) {
		this.militar = militar;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}

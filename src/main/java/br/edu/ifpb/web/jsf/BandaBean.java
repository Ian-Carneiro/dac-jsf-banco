package br.edu.ifpb.web.jsf;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.ifpb.model.dao.implementation.BandaDaoImpl;
import br.edu.ifpb.model.dao.intefaces.BandaDao;
import br.edu.ifpb.model.domain.Banda;

@SessionScoped
@Named
public class BandaBean implements Serializable{
	
	private BandaDao bandaService;
	
	private Banda banda;
	
	@PostConstruct
	public void init() {
		bandaService = new BandaDaoImpl();
		banda = new Banda();
	}
	
	public String salvar() {
		try {
			bandaService.cadastrar(banda);
			banda = new Banda();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String atualizar(){
		try {
			bandaService.atualizar(banda);
			banda = new Banda();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}

	public String excluir(Banda banda) {
		try {
			bandaService.excluir(banda);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}
}

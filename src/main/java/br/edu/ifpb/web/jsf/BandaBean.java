package br.edu.ifpb.web.jsf;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	private Banda banda = new Banda();
	
	@PostConstruct
	public void init() {
		bandaService = new BandaDaoImpl();
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
	
	public void selecionar(Banda banda) {
		this.banda = banda;
	}
	
	public List<Banda> listarBandas(){
//		return Arrays.asList(new Banda(1,"Las Vegas","Fantasia"),new Banda(2,"Florianópolis","Fantasia"));
		List<Banda> bandas = new ArrayList<>();
		try {
			bandas = bandaService.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bandas;
	}
	
	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}
}

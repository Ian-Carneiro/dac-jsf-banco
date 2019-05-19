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
import br.edu.ifpb.model.domain.Integrante;

@SessionScoped
@Named
public class BandaBean implements Serializable{
	
	private BandaDao bandaService;
	
	private Banda banda;
	
	private String consulta = "";
	
	private Banda resultadoConsulta;
	
	@PostConstruct
	public void init() {
		bandaService = new BandaDaoImpl();
		banda = new Banda();
		resultadoConsulta = new Banda();
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
	
	public String selecionar(Banda banda) {
		this.banda = banda;
		return "edit?faces-redirect=true";
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
	
	public void buscar() {
		try {
			resultadoConsulta = bandaService.buscarPorLocalDeOrigem(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Banda getResultadoConsulta() {
		return resultadoConsulta;
	}

	public void setResultadoConsulta(Banda resultadoConsulta) {
		this.resultadoConsulta = resultadoConsulta;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
}

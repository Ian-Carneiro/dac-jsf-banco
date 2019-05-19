package br.edu.ifpb.web.jsf;

import br.edu.ifpb.model.dao.implementation.IntegranteDaoImpl;
import br.edu.ifpb.model.dao.intefaces.IntegranteDao;
import br.edu.ifpb.model.domain.Integrante;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named

public class IntegranteBean implements Serializable {

    private IntegranteDao integranteDao;

    private Integrante integrante;

    private List<Integrante> integrantes;


    @PostConstruct
    public void init() {
        integranteDao = new IntegranteDaoImpl();
        integrante = new Integrante();

    }
    public Integrante getIntegrante() {
        return integrante;
    }
    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public String salvar() {
        try {
            this.integranteDao.cadastrar(integrante);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.integrante = new Integrante();
        return "index.xhtml?faces-redirect=true";
    }
    public List<Integrante> listarTodosOsIntegrantes(){
        try {
            return this.integranteDao.listar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String atualizar() {
        try {
            this.integranteDao.atualizar(integrante);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.integrante = new Integrante();
        return null;
    }

    public String excluir(Integrante integrante) {
        try {
            this.integranteDao.excluir(integrante);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}

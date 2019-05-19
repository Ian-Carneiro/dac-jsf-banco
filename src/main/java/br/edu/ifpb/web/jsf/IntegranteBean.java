package br.edu.ifpb.web.jsf;

import br.edu.ifpb.model.dao.implementation.IntegranteDaoImpl;
import br.edu.ifpb.model.dao.intefaces.IntegranteDao;
import br.edu.ifpb.model.domain.Integrante;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
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
}

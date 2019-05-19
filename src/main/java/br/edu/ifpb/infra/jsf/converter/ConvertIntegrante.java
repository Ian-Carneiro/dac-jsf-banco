package br.edu.ifpb.infra.jsf.converter;

import java.sql.SQLException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.model.dao.implementation.IntegranteDaoImpl;
import br.edu.ifpb.model.domain.CPF;
import br.edu.ifpb.model.domain.Integrante;

@FacesConverter(value="converter.integrante")
public class ConvertIntegrante implements Converter{
	
	IntegranteDaoImpl dao = new IntegranteDaoImpl();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null) {
			return null;
		}
		if(value.equals("-- NENHUM INTEGRANTE --")) {
			return null;
		}
		Integrante i;
		try {
			i = dao.buscarPorCpf(new CPF(value));
		} catch (SQLException e) {
			i = new Integrante();
		}
		
		return i;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value==null) {
			return null;
		}
		Integrante i = (Integrante)value;
		return i.getCpf().formatado();
	}
	
}

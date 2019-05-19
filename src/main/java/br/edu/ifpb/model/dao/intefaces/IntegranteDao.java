package br.edu.ifpb.model.dao.intefaces;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.model.domain.CPF;
import br.edu.ifpb.model.domain.Integrante;

public interface IntegranteDao extends Dao<Integrante>{

	Integrante buscarPorCpf(CPF cpf) throws SQLException;
	List<Integrante> buscarPorBanda(int idBanda) throws SQLException;

}

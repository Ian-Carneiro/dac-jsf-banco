package br.edu.ifpb.model.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.model.domain.CPF;
import br.edu.ifpb.model.domain.Integrante;

public interface IntegranteDao {
	void cadastrar(Integrante integrante) throws SQLException;
	void excluir(Integrante integrante) throws SQLException;
	void atualizar(Integrante integrante) throws SQLException;
	Integrante buscarPorCpf(CPF cpf) throws SQLException;
	List<Integrante> listar() throws SQLException;
}

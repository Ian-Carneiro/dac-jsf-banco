package br.edu.ifpb.model;

import java.util.List;

import br.edu.ifpb.model.domain.Integrante;

public interface IntegranteDao {
	void cadastrar(Integrante integrante);
	void excluir(Integrante integrante);
	void atualizar(Integrante integrante);
	Integrante buscarPorCpf(String cpf);
	List<Integrante> listar();
}

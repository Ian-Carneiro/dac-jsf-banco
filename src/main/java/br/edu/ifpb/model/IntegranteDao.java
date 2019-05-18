package br.edu.ifpb.model;

import java.util.List;

import br.edu.ifpb.model.domain.Integrante;

public interface IntegranteDao {
	void cadastrar();
	void excluir();
	void atualizar();
	Integrante buscarPorCpf();
	List<Integrante> listar();
}

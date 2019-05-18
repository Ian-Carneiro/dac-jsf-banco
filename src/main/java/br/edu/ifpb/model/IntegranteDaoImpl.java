package br.edu.ifpb.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.jdbc.ConnectionFactory;
import br.edu.ifpb.model.domain.Integrante;

public class IntegranteDaoImpl implements IntegranteDao{
	private Connection connection;
	public IntegranteDaoImpl() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	@Override
	public void cadastrar(Integrante integrante) throws SQLException {
		String sql = "insert into integrante(nome, dataDeNascimento, CPF) values (?,?,?)";
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, integrante.getNome());
		ps.setDate(2, Date.valueOf(integrante.getDataDeNascimento()));
		ps.setString(3, integrante.getCpf().formatado());
		ps.executeUpdate();
	}
	@Override
	public void excluir(Integrante integrante)  throws SQLException{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void atualizar(Integrante integrante)  throws SQLException{
		// TODO Auto-generated method stub
		
	}
	@Override
	public Integrante buscarPorCpf(String cpf)  throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Integrante> listar()  throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

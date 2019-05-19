package br.edu.ifpb.model.dao.intefaces;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.jdbc.ConnectionFactory;
import br.edu.ifpb.model.dao.implementation.IntegranteDao;
import br.edu.ifpb.model.domain.CPF;
import br.edu.ifpb.model.domain.Integrante;

public class IntegranteDaoImpl implements IntegranteDao {
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
		String sql = "delete from integrante where cpf=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, integrante.getCpf().formatado());
		ps.executeUpdate();
	}
	@Override
	public void atualizar(Integrante integrante)  throws SQLException{
		String sql = "update integrante set nome=?, dataDeNascimento=? where cpf=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, integrante.getNome());
		ps.setDate(2, Date.valueOf(integrante.getDataDeNascimento()));
		ps.setString(3, integrante.getCpf().formatado());
		ps.executeUpdate();
	}
	@Override
	public Integrante buscarPorCpf(CPF cpf)  throws SQLException{
		String sql = "select * from integrante where cpf=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, cpf.formatado());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return new Integrante(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), new CPF(rs.getString(4)));
		}
		return null;
	}
	@Override
	public List<Integrante> listar()  throws SQLException{
		String sql = "select * from integrante";
		List<Integrante> integrantes = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			integrantes.add(new Integrante(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), new CPF(rs.getString(4))));
		}
		return integrantes;
	}
	
	

}

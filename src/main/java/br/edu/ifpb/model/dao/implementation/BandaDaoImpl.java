package br.edu.ifpb.model.dao.implementation;

import br.edu.ifpb.jdbc.ConnectionFactory;
import br.edu.ifpb.model.dao.intefaces.BandaDao;
import br.edu.ifpb.model.domain.Banda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mailson
 */

public class BandaDaoImpl implements BandaDao {

    private Connection connection;

    public BandaDaoImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void cadastrar(Banda banda) throws SQLException {
        String sql = "INSERT INTO banda (localDeOrigem,nomeFantasia) VALUES (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,banda.getLocalDeOrigem());
        ps.setString(2,banda.getNomeFantasia());
        ps.executeUpdate();
    }

    @Override
    public void excluir(Banda banda) throws SQLException {
        String sql = "DELETE FROM banda WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,banda.getId());
        ps.executeUpdate();
    }

    @Override
    public void atualizar(Banda banda) throws SQLException {
        String sql = "UPDATE banda SET localDeOrigem = ?, nomeFantasia = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,banda.getLocalDeOrigem());
        ps.setString(2,banda.getNomeFantasia());
        ps.setInt(3,banda.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Banda> listar() throws SQLException {
        String sql = "SELECT * FROM banda";
        List<Banda> bandas = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            bandas.add(new Banda(rs.getInt("id"),rs.getString("localdeorigem"),rs.getString("nomeFantasia")));
        }
        return bandas;
    }

    @Override
    public Banda buscarPorLocalDeOrigem(String localDeOrigem) throws SQLException {
        String sql = "SELECT * FROM banda WHERE localDeOrigem ILIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,localDeOrigem);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new Banda(rs.getInt("id"),rs.getString("localDeOrgiem"),rs.getString("nomeFantasia"));
        }
        return null;
    }

}

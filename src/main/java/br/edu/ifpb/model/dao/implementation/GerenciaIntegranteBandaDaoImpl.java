package br.edu.ifpb.model.dao.implementation;

import br.edu.ifpb.jdbc.ConnectionFactory;
import br.edu.ifpb.model.dao.intefaces.GerenciaIntegranteBandaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mailson
 */
public class GerenciaIntegranteBandaDaoImpl implements GerenciaIntegranteBandaDao {

    private Connection connection;

    public GerenciaIntegranteBandaDaoImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void inserirParticipante(int idIntegrante, int idBanda) throws SQLException {
        String sql = "INSERT INTO integrante_banda (id_banda,id_integrante) VALUES (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,idBanda);
        ps.setInt(2,idIntegrante);
        ps.executeUpdate();
    }

    @Override
    public void removerParticipante(int idIntegrante, int idBanda) throws SQLException {
        String sql = "DELETE FROM integrante_banda WHERE id_banda = ? AND id_integrante = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,idBanda);
        ps.setInt(2,idIntegrante);
        ps.executeUpdate();
    }
}

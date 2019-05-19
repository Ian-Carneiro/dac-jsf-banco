package br.edu.ifpb.model.dao.intefaces;

import java.sql.SQLException;

/**
 * @author Mailson
 */
public interface GerenciaIntegranteBandaDao {

    void inserirParticipante(int idIntegrante,int idBanda) throws SQLException;
    void removerParticipante(int idIntegrante,int idBanda) throws SQLException;
}

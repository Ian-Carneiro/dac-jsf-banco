package br.edu.ifpb.model.dao.intefaces;

import br.edu.ifpb.model.domain.Banda;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mailson
 */
public interface ParticipaBandaDao {

    Banda buscarBandaComParticipantes(String localDeOrigem) throws SQLException;
    List<Banda> listarBandasComParticipantes() throws SQLException;
    void adicionarEmBanda(int idParticipante,int idBanda) throws SQLException;
    void removerDeBanda(int idParticipante,int idBand) throws SQLException;
}

package br.edu.ifpb.model.dao.intefaces;

import br.edu.ifpb.model.domain.Banda;

import java.sql.SQLException;

public interface ParticipaBandaDao {

    Banda buscarBandaComParticipantes(int idBanda) throws SQLException;

}

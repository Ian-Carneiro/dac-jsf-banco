package br.edu.ifpb.model.dao.intefaces;

import br.edu.ifpb.model.domain.Banda;

import java.sql.SQLException;

public interface BandaDao extends Dao<Banda> {

    Banda buscarPorLocalDeOrigem(String localDeOrigem) throws SQLException;

}

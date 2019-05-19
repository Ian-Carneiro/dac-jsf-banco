package br.edu.ifpb.model.dao.implementation;

import br.edu.ifpb.model.dao.intefaces.BandaDao;
import br.edu.ifpb.model.dao.intefaces.IntegranteDao;
import br.edu.ifpb.model.dao.intefaces.ParticipaBandaDao;
import br.edu.ifpb.model.domain.Banda;

import java.sql.SQLException;
import java.util.List;

public class ParticipaBandaDaoImpl implements ParticipaBandaDao {

    private BandaDao bandaDao;
    private IntegranteDao integranteDao;

    public ParticipaBandaDaoImpl() {
        bandaDao = new BandaDaoImpl();
        integranteDao = new IntegranteDaoImpl();
    }

    @Override
    public Banda buscarBandaComParticipantes(String localDeOrgiem) throws SQLException {
        Banda banda = bandaDao.buscarPorLocalDeOrigem(localDeOrgiem);
        banda.setIntegrantes(integranteDao.buscarPorBanda(banda.getId()));
        return banda;
    }

    @Override
    public List<Banda> listarBandasComParticipantes() throws SQLException {
        List<Banda> bandas = bandaDao.listar();
        for (Banda banda:bandas){
            banda.setIntegrantes(integranteDao.buscarPorBanda(banda.getId()));
        }
        return bandas;
    }
}

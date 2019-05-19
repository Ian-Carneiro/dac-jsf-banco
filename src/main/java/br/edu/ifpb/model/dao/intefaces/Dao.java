package br.edu.ifpb.model.dao.intefaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T> {
    void cadastrar (T object) throws SQLException;
    void excluir (T object) throws SQLException;
    void atualizar (T object) throws SQLException;
    List<T> listar () throws SQLException;
}

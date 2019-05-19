import java.sql.SQLException;
import java.time.LocalDate;

import br.edu.ifpb.model.dao.implementation.IntegranteDaoImpl;
import br.edu.ifpb.model.domain.CPF;
import br.edu.ifpb.model.domain.Integrante;

public class App {

	public static void main(String[] args) throws SQLException {
		Integrante i = new Integrante(1, "Zé", LocalDate.now(), new CPF("12312312313"));
		IntegranteDaoImpl dao = new IntegranteDaoImpl();
		dao.cadastrar(i);
		System.out.println(dao.listar());
		
	}

}

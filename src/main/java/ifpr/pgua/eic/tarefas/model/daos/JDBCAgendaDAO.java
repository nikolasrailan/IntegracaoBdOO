package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.FabricaConexoes;

public class JDBCAgendaDAO implements AgendaDAO {
  private static final String INSERTSQL = "INSERT INTO agenda(nome) VALUES (?)";

  private FabricaConexoes fabrica;

  public JDBCAgendaDAO(FabricaConexoes fabrica) {
    this.fabrica = fabrica;
  }

  @Override
  public Resultado criar(Agenda agenda) {
    try (Connection con = fabrica.getConnection()) {

      PreparedStatement pstm = con.prepareStatement(INSERTSQL, Statement.RETURN_GENERATED_KEYS);

      pstm.setString(1, agenda.getNome());

      int ret = pstm.executeUpdate();

      if (ret == 1) {
        ResultSet rs = pstm.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);

        agenda.setCodigo(id);

        return Resultado.sucesso("Agenda cadastrada", agenda);
      }
      return Resultado.erro("Erro desconhecido!");

    } catch (SQLException e) {
      return Resultado.erro(e.getMessage());
    }
  }

  @Override
  public Resultado listar() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listar'");
  }

  @Override
  public Resultado atualizar(int id, Agenda nova) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
  }

  @Override
  public Resultado deletar(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deletar'");
  }

}

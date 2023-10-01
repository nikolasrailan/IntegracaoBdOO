package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Email;
import ifpr.pgua.eic.tarefas.model.entities.FabricaConexoes;

public class JDBCEmailDAO implements EmailDAO {

  private static final String INSERTSQL = "INSERT INTO email(email, codigo) VALUES (?,?)";
  private FabricaConexoes fabrica;

  public JDBCEmailDAO(FabricaConexoes fabrica) {
    this.fabrica = fabrica;
  }

  @Override
  public Resultado criar(Email email) {
    try (Connection con = fabrica.getConnection()) {

      PreparedStatement pstm = con.prepareStatement(INSERTSQL, Statement.RETURN_GENERATED_KEYS);

      pstm.setString(1, email.getEmail());
      pstm.setInt(2, email.getCodigo());

      int ret = pstm.executeUpdate();

      if (ret == 1) {
        ResultSet rs = pstm.getGeneratedKeys();
        rs.next();

        return Resultado.sucesso("Email cadastrado", email);
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
  public Resultado atualizar(int id, Email nova) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
  }

  @Override
  public Resultado deletar(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deletar'");
  }

}

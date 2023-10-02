package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Email;
import ifpr.pgua.eic.tarefas.model.entities.FabricaConexoes;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;

public class JDBCEmailDAO implements EmailDAO {

  private static final String INSERTSQL = "INSERT INTO email(email, codigo) VALUES (?,?)";
  private static final String SELECTSQL = "SELECT * FROM email";
  private static final String DELETESQL = "DELETE FROM email WHERE codigo = ?";

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
    try {
      Connection con = fabrica.getConnection();

      PreparedStatement pstm = con.prepareStatement(SELECTSQL);

      ResultSet rs = pstm.executeQuery();

      ArrayList<Email> lista = new ArrayList<>();
      while (rs.next()) {
        int id = rs.getInt("codigo");
        String e = rs.getString("email");

        Email email = new Email(e, id);
        lista.add(email);
      }
      rs.close();
      pstm.close();
      con.close();

      return Resultado.sucesso("Lista.", lista);
    } catch (SQLException e) {
      return Resultado.erro("Problema na consulta: " + e.getMessage());
    }
  }

  @Override
  public Resultado atualizar(int id, Email nova) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
  }

  @Override
  public Resultado deletar(int id) {
    try {
      Connection con = fabrica.getConnection();

      PreparedStatement pstm = con.prepareStatement(DELETESQL);

      pstm.setInt(1, id);

      int ret = pstm.executeUpdate();

      if (ret == 1) {
        return Resultado.sucesso("Email excluido", id);
      }
      pstm.close();
      con.close();

      return Resultado.erro("Erro ao excluir");
    } catch (SQLException e) {
      return Resultado.erro("Problema ao excluir: " + e.getMessage());
    }
  }

}

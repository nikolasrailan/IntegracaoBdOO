package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.FabricaConexoes;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;

public class JDBCTelefoneDAO implements TelefoneDAO {
  private static final String INSERTSQL = "INSERT INTO telefone(telefone, codigo) VALUES (?,?)";
  private static final String SELECTSQL = "SELECT * FROM telefone";
  private static final String DELETESQL = "DELETE FROM telefone WHERE codigo = ?";

  private FabricaConexoes fabrica;

  public JDBCTelefoneDAO(FabricaConexoes fabrica) {
    this.fabrica = fabrica;
  }

  @Override
  public Resultado criar(Telefone telefone) {
    try (Connection con = fabrica.getConnection()) {

      PreparedStatement pstm = con.prepareStatement(INSERTSQL, Statement.RETURN_GENERATED_KEYS);

      pstm.setInt(1, telefone.getTelefone());
      pstm.setInt(2, telefone.getCodigo());

      int ret = pstm.executeUpdate();

      if (ret == 1) {
        ResultSet rs = pstm.getGeneratedKeys();
        rs.next();

        return Resultado.sucesso("Telefone cadastrado", telefone);
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

      ArrayList<Telefone> lista = new ArrayList<>();
      while (rs.next()) {
        int id = rs.getInt("codigo");
        int tel = rs.getInt("telefone");

        Telefone telefone = new Telefone(tel, id);
        lista.add(telefone);
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
  public Resultado atualizar(int id, Telefone nova) {
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
        return Resultado.sucesso("Telefone excluido", id);
      }
      pstm.close();
      con.close();

      return Resultado.erro("Erro ao excluir");
    } catch (SQLException e) {
      return Resultado.erro("Problema ao excluir: " + e.getMessage());
    }
  }

}

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
    try {
      Connection con = fabrica.getConnection();

      PreparedStatement pstm = con.prepareStatement("SELECT * FROM agenda");

      ResultSet rs = pstm.executeQuery();

      ArrayList<Agenda> lista = new ArrayList<>();
      while (rs.next()) {
        int id = rs.getInt("codigo");
        String nome = rs.getString("nome");

        Agenda agenda = new Agenda(nome, null, null, id);
        lista.add(agenda);
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
  public Resultado atualizar(int id, Agenda nova) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
  }

  @Override
  public Resultado deletar(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deletar'");
  }

  @Override
  public Resultado buscar(String codigo, String nome) {
    String sqlcod = "codigo=? ";
    String sql = "SELECT * FROM agenda where ";
    String sqlnome = "nome=?";
    int count =0;
    if(!nome.isBlank() ||!nome.isEmpty()){
      sql = sql+sqlnome;
      count++;
    }
    if(!codigo.isBlank() ||!codigo.isEmpty()){
      sql = sql+sqlcod;
      count++;
    }
    try {
      Connection con = fabrica.getConnection();

      PreparedStatement pstm = con.prepareStatement(sql);

      if(count ==2){
        pstm.setString(1,nome);
        pstm.setString(2, codigo);
      }else if(!codigo.isBlank() || !codigo.isEmpty()){
        pstm.setString(1, codigo);
      }else{
        pstm.setString(1, nome);
      }

      ResultSet rs = pstm.executeQuery();

      ArrayList<Agenda> lista = new ArrayList<>();
      while (rs.next()) {
        int id = rs.getInt("codigo");
        String nomeString = rs.getString("nome");

        Agenda agenda = new Agenda(nomeString, null, null, id);
        lista.add(agenda);
      }
      rs.close();
      pstm.close();
      con.close();

      return Resultado.sucesso("Lista.", lista);
    } catch (SQLException e) {
      return Resultado.erro("Problema na consulta: " + e.getMessage());
    }
  }

}

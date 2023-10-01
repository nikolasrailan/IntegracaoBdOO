package ifpr.pgua.eic.tarefas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.TelefoneDAO;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;

public class RepositorioTelefone {
  private TelefoneDAO dao;

  public RepositorioTelefone(TelefoneDAO dao) {
    this.dao = dao;
  }

  public Resultado cadastrarTelefone(String telefone, Agenda agenda) {
    if (agenda == null) {
      return Resultado.erro("Agenda inválida!");
    }
    if (telefone.isBlank() || telefone.isEmpty()) {
      return Resultado.erro("Telefone inválido!");
    }

    Telefone telefoneObj = new Telefone(Integer.parseInt(telefone), agenda.getCodigo());

    return dao.criar(telefoneObj);
  }
}

package ifpr.pgua.eic.tarefas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.AgendaDAO;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;

public class RepositorioAgenda {
  private AgendaDAO dao;

  public RepositorioAgenda(AgendaDAO dao) {
    this.dao = dao;
  }

  public Resultado cadastrarArtista(String nome) {
    if (nome.isBlank() || nome.isEmpty()) {
      return Resultado.erro("Nome inválido!");
    }

    Agenda agenda = new Agenda(nome, null, null);

    return dao.criar(agenda);
  }
}

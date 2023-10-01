package ifpr.pgua.eic.tarefas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.EmailDAO;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.Email;

public class RepositorioEmail {
  private EmailDAO dao;

  public RepositorioEmail(EmailDAO dao) {
    this.dao = dao;
  }

  public Resultado cadastrarEmail(String email, Agenda agenda) {
    if (agenda == null) {
      return Resultado.erro("Agenda inválida!");
    }
    if (email.isBlank() || email.isEmpty()) {
      return Resultado.erro("Email inválido!");
    }

    Email emailObj = new Email(email, agenda.getCodigo());

    return dao.criar(emailObj);
  }
}

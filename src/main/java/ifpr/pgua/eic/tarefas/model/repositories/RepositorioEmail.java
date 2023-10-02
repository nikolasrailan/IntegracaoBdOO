package ifpr.pgua.eic.tarefas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.EmailDAO;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.Email;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;

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

  public Resultado listar() {
    return dao.listar();
  }

  public Resultado excluir(Email email) {
    if (email == null) {
      return Resultado.erro("Email inválido.");
    }

    return dao.deletar(email.getCodigo());

  }
}

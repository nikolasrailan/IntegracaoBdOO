package ifpr.pgua.eic.tarefas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Email;

public interface EmailDAO {

  Resultado criar(Email email);

  Resultado listar();

  Resultado atualizar(int id, Email nova);

  Resultado deletar(int id);
}

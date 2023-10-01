package ifpr.pgua.eic.tarefas.model.entities;

public class Agenda {
  private String nome;
  private Telefone telefone;
  private Email email;
  private int codigo;

  public Agenda(String nome, Telefone telefone, Email email, int codigo) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.codigo = codigo;
  }

  public Agenda(String nome, Telefone telefone, Email email) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email email) {
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Telefone getTelefone() {
    return telefone;
  }

  public void setTelefone(Telefone telefone) {
    this.telefone = telefone;
  }
}

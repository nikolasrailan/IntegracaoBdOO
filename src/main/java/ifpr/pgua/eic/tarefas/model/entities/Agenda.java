package ifpr.pgua.eic.tarefas.model.entities;

import java.util.ArrayList;

public class Agenda {
  private String nome;
  private ArrayList<Telefone> telefone;
  private ArrayList<Email> email;
  private int codigo;

  public Agenda(String nome, ArrayList<Telefone> telefone, ArrayList<Email> email, int codigo) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.codigo = codigo;
  }

  public Agenda(String nome, ArrayList<Telefone> telefone, ArrayList<Email> email) {
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

  public ArrayList<Email> getEmail() {
    return email;
  }

  public void setEmail(ArrayList<Email> email) {
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<Telefone> getTelefone() {
    return telefone;
  }

  public void setTelefone(ArrayList<Telefone> telefone) {
    this.telefone = telefone;
  }

  @Override
  public String toString() {
    return "Agenda [nome=" + nome + ", codigo=" + codigo + "]";
  }
}

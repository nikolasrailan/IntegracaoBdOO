package ifpr.pgua.eic.tarefas.model.entities;

public class Telefone {
  private int telefone;
  private int codigo;

  public Telefone(int telefone, int codigo) {
    this.telefone = telefone;
    this.codigo = codigo;
  }

  public Telefone(int telefone) {
    this.telefone = telefone;
  }

  public int getTelefone() {
    return telefone;
  }

  public void setTelefone(int telefone) {
    this.telefone = telefone;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  @Override
  public String toString() {
    return "Telefone:" + telefone + " / Codigo: " + codigo;
  }
}

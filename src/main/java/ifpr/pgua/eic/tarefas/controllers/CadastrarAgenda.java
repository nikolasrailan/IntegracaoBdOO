package ifpr.pgua.eic.tarefas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadastrarAgenda {
  @FXML
  private TextField tfNome;

  private RepositorioAgenda repositorio;

  public CadastrarAgenda(RepositorioAgenda repositorio) {
    this.repositorio = repositorio;
  }

  @FXML
  void cadastrar(ActionEvent event) {

    String nome = tfNome.getText();

    Resultado rs = repositorio.cadastrarArtista(nome);

    Alert alert;
    String msg = rs.getMsg();
    if (rs.foiErro()) {
      alert = new Alert(AlertType.ERROR, msg);
    } else {
      alert = new Alert(AlertType.INFORMATION, msg);

    }

    alert.showAndWait();
  }

  @FXML
  void voltar(ActionEvent event) {
    App.popScreen();
  }
}

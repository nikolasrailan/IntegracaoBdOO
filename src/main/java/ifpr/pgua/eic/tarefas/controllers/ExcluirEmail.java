package ifpr.pgua.eic.tarefas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.Email;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioEmail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class ExcluirEmail implements Initializable {

  private RepositorioEmail repositorioEmail;

  public ExcluirEmail(RepositorioEmail repositorioEmail) {
    this.repositorioEmail = repositorioEmail;
  }

  @FXML
  private ListView<Email> lstEmail;

  @FXML
  void excluir(ActionEvent event) {
    Email email = lstEmail.getSelectionModel().getSelectedItem();

    Resultado resultado = repositorioEmail.excluir(email);

    Alert alert;
    String msg = resultado.getMsg();
    if (resultado.foiErro()) {
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

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    lstEmail.getItems().clear();

    Resultado r = repositorioEmail.listar();

    if (r.foiSucesso()) {
      List<Email> lista = (List) r.comoSucesso().getObj();
      lstEmail.getItems().addAll(lista);
    } else {
      Alert alert = new Alert(AlertType.ERROR, r.getMsg());
      alert.showAndWait();
    }
  }
}

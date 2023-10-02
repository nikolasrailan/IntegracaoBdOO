package ifpr.pgua.eic.tarefas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioTelefone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class ExcluirTelefone implements Initializable {

  private RepositorioTelefone repositorioTelefone;

  public ExcluirTelefone(RepositorioTelefone repositorioTelefone) {
    this.repositorioTelefone = repositorioTelefone;
  }

  @FXML
  private ListView<Telefone> lstTelefone;

  @FXML
  void excluir(ActionEvent event) {
    Telefone telefone = lstTelefone.getSelectionModel().getSelectedItem();

    Resultado resultado = repositorioTelefone.excluir(telefone);

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
    lstTelefone.getItems().clear();

    Resultado r = repositorioTelefone.listar();

    if (r.foiSucesso()) {
      List<Telefone> lista = (List) r.comoSucesso().getObj();
      lstTelefone.getItems().addAll(lista);
    } else {
      Alert alert = new Alert(AlertType.ERROR, r.getMsg());
      alert.showAndWait();
    }
  }
}

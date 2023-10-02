package ifpr.pgua.eic.tarefas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioEmail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastrarEmail implements Initializable {
  @FXML
  private ComboBox<Agenda> cbAgenda;

  @FXML
  private TextField tfEmail;

  private RepositorioAgenda repositorioAgenda;

  private RepositorioEmail repositorio;

  public CadastrarEmail(RepositorioEmail repositorio, RepositorioAgenda repositorioAgenda) {
    this.repositorio = repositorio;
    this.repositorioAgenda = repositorioAgenda;
  }

  @FXML
  void cadastrar(ActionEvent event) {

    String email = tfEmail.getText();
    Agenda agenda = cbAgenda.getSelectionModel().getSelectedItem();
    Resultado rs = repositorio.cadastrarEmail(email, agenda);

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

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    Resultado r1 = repositorioAgenda.listar();

    if (r1.foiSucesso()) {
      List<Agenda> list = (List) r1.comoSucesso().getObj();
      cbAgenda.getItems().addAll(list);
    } else {
      Alert alert = new Alert(AlertType.ERROR, r1.getMsg());
      alert.showAndWait();
    }
  }
}

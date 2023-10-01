package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastrarEmail {
  @FXML
  private ComboBox<?> cbAgenda;

  @FXML
  private TextField tfEmail;

  @FXML
  void cadastrar(ActionEvent event) {

  }

  @FXML
  void voltar(ActionEvent event) {
    App.popScreen();
  }
}

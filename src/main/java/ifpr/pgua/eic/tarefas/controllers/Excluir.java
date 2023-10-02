package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Excluir {

  @FXML
  void excluirAgenda(ActionEvent event) {

  }

  @FXML
  void excluirEmail(ActionEvent event) {

  }

  @FXML
  void excluirTelefone(ActionEvent event) {
    App.pushScreen("EXCLUIRTELEFONE");
  }

  @FXML
  void voltar(ActionEvent event) {
    App.popScreen();
  }
}

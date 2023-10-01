package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Cadastrar {
  @FXML
  void agenda(ActionEvent event) {
    App.pushScreen("CADASTRARAGENDA");
  }

  @FXML
  void email(ActionEvent event) {
    App.pushScreen("CADASTRAREMAIL");
  }

  @FXML
  void telefone(ActionEvent event) {
    App.pushScreen("CADASTRARTELEFONE");
  }

  @FXML
  void voltar(ActionEvent event) {
    App.popScreen();
  }
}

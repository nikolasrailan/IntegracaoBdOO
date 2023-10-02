package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Principal {
  @FXML
  void alterar(ActionEvent event) {

  }

  @FXML
  void buscar(ActionEvent event) {
    App.pushScreen("BUSCAR");
  }

  @FXML
  void cadastrar(ActionEvent event) {
    App.pushScreen("CADASTRAR");
  }

  @FXML
  void excluir(ActionEvent event) {
    App.pushScreen("EXCLUIR");
  }
}

package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Buscar {

    
    @FXML
    void agenda(ActionEvent event) {
        App.pushScreen("BUSCARAGENDA");
    }

    @FXML
    void email(ActionEvent event) {
        App.pushScreen("BUSCAREMAIL");
    }

    @FXML
    void telefone(ActionEvent event) {
        App.pushScreen("BUSCARTELEFONE");
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

}

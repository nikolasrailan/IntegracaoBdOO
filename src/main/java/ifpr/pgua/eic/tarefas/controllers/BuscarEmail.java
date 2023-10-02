package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.Email;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BuscarEmail {
    
    @FXML
    private ListView<Email> lstEmail;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfEmail;

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}

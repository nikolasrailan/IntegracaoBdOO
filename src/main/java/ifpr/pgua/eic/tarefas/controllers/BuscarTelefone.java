package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BuscarTelefone {
    @FXML
    private ListView<Telefone> lstTelefone;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfTelefone;

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}

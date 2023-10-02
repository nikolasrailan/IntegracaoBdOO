package ifpr.pgua.eic.tarefas.controllers;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BuscarAgenda {
    
    @FXML
    private ListView<Agenda> lstAgenda;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    private RepositorioAgenda repositorio;

  public BuscarAgenda(RepositorioAgenda repositorio) {
    this.repositorio = repositorio;
  }

    @FXML
    void buscar(ActionEvent event) {
        lstAgenda.getItems().clear();
        String codigo = tfCodigo.getText();
        String nome = tfNome.getText();
        Resultado rs = repositorio.buscar(codigo, nome);
        if(rs.foiSucesso()){
            lstAgenda.getItems().addAll((List)rs.comoSucesso().getObj());
        }else{
            Alert alert;
            String msg = rs.getMsg();
            alert = new Alert(AlertType.ERROR, msg);

            alert.showAndWait();
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}

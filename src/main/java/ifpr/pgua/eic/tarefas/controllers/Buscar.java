package ifpr.pgua.eic.tarefas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.Email;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Buscar {

    @FXML
    private ListView<Agenda> lstAgenda;

    @FXML
    private ListView<Email> lstEmail;

    @FXML
    private ListView<Telefone> lstTelefone;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    private RepositorioAgenda repositorio;

    public Buscar(RepositorioAgenda repositorio) {
      this.repositorio = repositorio;
    }

    @FXML
    void buscar(ActionEvent event) {

        String codigo = tfCodigo.getText();
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();
        Resultado rs = repositorio.buscar(codigo,nome,email,telefone);
    //preencher as listas com o retorno
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

}

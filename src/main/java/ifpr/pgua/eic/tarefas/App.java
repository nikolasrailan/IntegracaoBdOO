package ifpr.pgua.eic.tarefas;

import ifpr.pgua.eic.tarefas.controllers.Cadastrar;
import ifpr.pgua.eic.tarefas.controllers.CadastrarAgenda;
import ifpr.pgua.eic.tarefas.controllers.Principal;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Agenda";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o -> new Principal()));
        registraTela("CADASTRAR", new ScreenRegistryFXML(App.class, "cadastrar.fxml", o -> new Cadastrar()));
        registraTela("CADASTRARAGENDA",
                new ScreenRegistryFXML(App.class, "cadastrar_agenda.fxml", o -> new CadastrarAgenda()));
    }

}
package ifpr.pgua.eic.tarefas;

import ifpr.pgua.eic.tarefas.controllers.Buscar;
import ifpr.pgua.eic.tarefas.controllers.BuscarAgenda;
import ifpr.pgua.eic.tarefas.controllers.BuscarEmail;
import ifpr.pgua.eic.tarefas.controllers.BuscarTelefone;
import ifpr.pgua.eic.tarefas.controllers.Cadastrar;
import ifpr.pgua.eic.tarefas.controllers.CadastrarAgenda;
import ifpr.pgua.eic.tarefas.controllers.CadastrarEmail;
import ifpr.pgua.eic.tarefas.controllers.CadastrarTelefone;
import ifpr.pgua.eic.tarefas.controllers.Principal;
import ifpr.pgua.eic.tarefas.model.daos.AgendaDAO;
import ifpr.pgua.eic.tarefas.model.daos.EmailDAO;
import ifpr.pgua.eic.tarefas.model.daos.JDBCAgendaDAO;
import ifpr.pgua.eic.tarefas.model.daos.JDBCEmailDAO;
import ifpr.pgua.eic.tarefas.model.daos.JDBCTelefoneDAO;
import ifpr.pgua.eic.tarefas.model.daos.TelefoneDAO;
import ifpr.pgua.eic.tarefas.model.entities.FabricaConexoes;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioEmail;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioTelefone;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private AgendaDAO agendaDAO = new JDBCAgendaDAO(FabricaConexoes.getInstance());
    private RepositorioAgenda repositorioAgenda = new RepositorioAgenda(agendaDAO);

    private TelefoneDAO telefoneDAO = new JDBCTelefoneDAO(FabricaConexoes.getInstance());
    private RepositorioTelefone repositorioTelefone = new RepositorioTelefone(telefoneDAO);

    private EmailDAO emailDAO = new JDBCEmailDAO(FabricaConexoes.getInstance());
    private RepositorioEmail repositorioEmail = new RepositorioEmail(emailDAO);

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
                new ScreenRegistryFXML(App.class, "cadastrar_agenda.fxml",
                        o -> new CadastrarAgenda(repositorioAgenda)));
        registraTela("CADASTRAREMAIL",
                new ScreenRegistryFXML(App.class, "cadastrar_email.fxml",
                        o -> new CadastrarEmail(repositorioEmail, repositorioAgenda)));
        registraTela("CADASTRARTELEFONE",
                new ScreenRegistryFXML(App.class, "cadastrar_telefone.fxml",
                        o -> new CadastrarTelefone(repositorioTelefone, repositorioAgenda))); 
        registraTela("BUSCAR", new ScreenRegistryFXML(App.class, "buscar.fxml", o -> new Buscar()));
        registraTela("BUSCARAGENDA", new ScreenRegistryFXML(App.class, "buscar_agenda.fxml", o -> new BuscarAgenda(repositorioAgenda)));
        registraTela("BUSCAREMAIL", new ScreenRegistryFXML(App.class, "buscar_email.fxml", o -> new BuscarEmail()));
        registraTela("BUSCARTELEFONE", new ScreenRegistryFXML(App.class, "buscar_telefone.fxml", o -> new BuscarTelefone()));
    }

}
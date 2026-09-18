package bibliotech;
import bibliotech.armazenamento.DadosUsers;
import bibliotech.menu.*;
import bibliotech.cadastro.*;
import bibliotech.validator.*;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                ██████  ██ ██████  ██      ██  ██████  ████████ ███████  ██████ ██   ██\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ██      ██ ██    ██    ██    █████   ██      ███████\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ███████ ██  ██████     ██    ███████  ██████ ██   ██\s
                """);
        CadUsuario cadastro = new CadUsuario();

//        try {
//            Autenticator.autenticacao();
//        } catch (NullPointerException e){
//            System.out.println("Usuario não cadastrado !!!");
//            cadastro.add();
//        }
        Autenticator.autenticacao();

        Autenticator.nivelAcesso(CadUsuario.getEmailUsuario());

        Menu.menuPrincipal();
    }
}

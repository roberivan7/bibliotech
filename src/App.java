import cadastro.*;
import validator.*;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                ██████  ██ ██████  ██      ██  ██████  ████████ ███████  ██████ ██   ██\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ██      ██ ██    ██    ██    █████   ██      ███████\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ███████ ██  ██████     ██    ███████  ██████ ██   ██\s
                """);
        CadUsuario cadatro = new CadUsuario();

        try {
            Autenticator.autenticacao();
        } catch (NullPointerException e){
            System.out.println("Usuario não cadastrado !!!");
            cadatro.add();
        }

        System.out.print("Bem vindo Sr(a)!!!");
    }
}

import validator.Autenticator;
import validator.VerificationUser;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                ██████  ██ ██████  ██      ██  ██████  ████████ ███████  ██████ ██   ██\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ██      ██ ██    ██    ██    █████   ██      ███████\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ███████ ██  ██████     ██    ███████  ██████ ██   ██\s
                """);
        Autenticator.autenticacao();
        System.out.print("Bem vindo Sr(a)!!!");
    }
}

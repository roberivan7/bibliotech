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
            Autenticator.secundario();
        }
        
        System.out.println("""
                    --------------- MENU ---------------
                    [1] - Acervo
                    [2] - Editar Livros    
                    [3] - Adicionar Livros
                    [4] - Pegar Livro
                    [5] - Devolver Livro
        """);
    }
}

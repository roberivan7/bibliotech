package program;

import java.util.Scanner;

import static program.dados.verificarUser;

public class start {

    public static void inicio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ██████  ██ ██████  ██      ██  ██████  ████████ ███████  ██████ ██   ██\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ██      ██ ██    ██    ██    █████   ██      ███████\s
                ██   ██ ██ ██   ██ ██      ██ ██    ██    ██    ██      ██      ██   ██\s
                ██████  ██ ██████  ███████ ██  ██████     ██    ███████  ██████ ██   ██\s
                
                
                Informe seu Login:
                (Obs: Caso não tenha Login clique em 'Enter')
                """);
        String login = sc.next();
        System.out.println("Informe a senha:");
        String senha = sc.next();

        try {
            if (verificarUser(login, senha)){
                System.out.println("Login realizado com sucesso!");
            }else {
                System.out.println("Login ou senha inválidos.");
                cadastro.cadastroUsuario();
            }
        } catch (NullPointerException e) {
            cadastro.cadastroUsuario();
        }

    }

    public static void secundario(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe seu email: ");
        String email = sc.next();
        System.out.print("Informe sua senha: ");
        String senha = sc.next();
        if (verificarUser(email,senha)){
            System.out.println("Voce tem cadastro conosco !!!");
        }else {
            System.out.println("Aconteceu algum erro no salvamento das suas credenciais\n Ache o Error !!!");
        }
    }
}

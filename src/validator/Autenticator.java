package validator;
import armazenamento.*;
import cadastro.CadUsuario;
import java.util.Scanner;

public class Autenticator {

    public static void autenticacao(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Informe seu Login:
                (Obs: Caso não tenha Login clique em 'Enter')
                """);
        String login = sc.next();
        System.out.println("Informe a senha:");
        String senha = sc.next();

        if (verificarUser(login, senha)){
            System.out.println("Login realizado com sucesso!");
            CadUsuario.setEmailUsuario(login);
        }else {
            System.out.println("Login ou senha inválidos.");
        }
    }

//    public static void secundario(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Informe seu email: ");
//        String email = sc.next();
//        System.out.print("Informe sua senha: ");
//        String senha = sc.next();
//        if (verificarUser(email,senha)){
//            System.out.println("Voce tem cadastro conosco !!!");
//        }else {
//            System.out.println("Aconteceu algum erro no salvamento das suas credenciais\n Ache o Error !!!");
//        }
//    }

    public static boolean verificarUser(String email, String senha){
        return DadosUsers.getDataPessoa().get(email).contains(senha);
    }
}

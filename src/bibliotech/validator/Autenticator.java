package bibliotech.validator;
import bibliotech.armazenamento.*;
import bibliotech.cadastro.CadUsuario;
import java.util.Scanner;

public class Autenticator {

    public static void autenticacao(){
        Scanner sc = new Scanner(System.in);
        CadUsuario cad = new CadUsuario();
        System.out.println("""
                Informe seu Email:
                (Obs: Caso não tenha Cadastro clique 'Enter')
                """);
        String email = sc.nextLine(); // o .next() foi tirado pois o metodo não recebe valor vazio, pois o mesmo esperar voce digitar um valor qualquer mesmo clicando em "enter"

        if (verificarUserEmail(email)){
            System.out.println("Informe a senha:");
            String senha = sc.next();
            if (verificarUserSenha(senha,email)){
                System.out.println("Login realizado com sucesso!");
                CadUsuario.setEmailUsuario(email);
                System.out.println("Seja bem-vindo(a) Sr(a) " + DadosUsers.getDataPessoa().get(email).getFirst() + " a Bibliotech !");
            }else{
                System.out.println("Senha Invalida, tente novamente !!!");
                for (int i = 0; i < 2; i++) {
                    System.out.println("Informe a senha:\n\n Esqueceu a Senha ? -> Clique 'A'");
                    String senha2 = sc.next().toLowerCase();

                    if(verificarUserSenha(senha2,email)){
                        System.out.println("Seja bem-vindo(a) Sr(a) " + DadosUsers.getDataPessoa().get(email).getFirst() + " a Bibliotech !");
                        CadUsuario.setEmailUsuario(email);
                    }else if(senha2.equals("a")){
                        recuperarSenha();
                        break;
                    }else if(i==1){
                        System.out.println("Já foram 3 tentativas, Tente novamente mais tarde");
                    }else{
                        System.out.println("Senha Invalida, Você tem somente 1 tentativa");
                    }
                }
            }
        }else if (email.isEmpty()){ // verificação se usuario quer fazer o cadastro do zero
            cad.add();
        }else {
            System.out.println("Email não cadastro. Tente Novamente !!!");
            autenticacao();
        }
    }

    public static boolean verificarUserEmail(String email){
        return DadosUsers.getDataPessoa().containsKey(email);
    }

    public static boolean verificarUserSenha(String senha, String email){
        return DadosUsers.getDataPessoa().get(email).contains(senha);
    }

    public static void recuperarSenha(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print(""" 
                    \n
                    -------------- Recuperação Senha --------------
                    Informe seu email:
                    """);
            String email = sc.next();

            if (DadosUsers.getDataPessoa().containsKey(email)){
                for (int t = 0; t <= 3; t++) {
                    System.out.println("Informe seu cpf: \n\nObs: Sem traços (-) ou barra (.), somente números");
                    String cpf = sc.next();
                    if (DadosUsers.getDataPessoa().get(email).get(2).equals(cpf)){
                        System.out.print("Informe sua nova senha: ");
                        String novaSenha = sc.next();
                        DadosUsers.getDataPessoa().get(email).set(1,novaSenha);
                        System.out.println("Senha Alterado com sucesso !!!\n\nVocê será redirecionado para a area de login.\n\n");
                        autenticacao();
                        break;
                    }else{
                        System.out.println(t==3?"Acabou suas tentativas, tente mais tarde":"CPF não localidado, tente novamente !!!\n\n"+(3-t)+" Tentativa(s) restante(s)");
                    }
                }
                break;
            }else {
                System.out.printf("Email não localizado, tente novamente %s !!!",(i==2?"mais tarde":""));
            }
        }
    }
}
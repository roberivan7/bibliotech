package validator;
import armazenamento.*;
import cadastro.CadUsuario;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Autenticator {

    private static nivelAcesso tipoUser;

    public enum nivelAcesso {
        ADM,
        USER
    }

    public static void autenticacao(){
        Scanner sc = new Scanner(System.in);
        CadUsuario cad = new CadUsuario();
        System.out.println("""
                Informe seu Login:
                (Obs: Caso não tenha Cadastro clique 'Enter')
                """);
        String login = sc.next();
        if (login.isEmpty()){ cad.add();} // verificação se usuario quer fazer o cadastro do zero
        System.out.println("Informe a senha:");
        String senha = sc.next();

        if (verificarUser(login, senha)){
            System.out.println("Login realizado com sucesso!");
            CadUsuario.setEmailUsuario(login);
        }else {
            System.out.println("Login ou senha inválidos. Tente Novamente !!!");
            autenticacao();
        }
    }

    public static void secundario(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.print("Informe seu email: ");
            String email = sc.next();
            System.out.print("Informe sua senha: \n\n Caso esqueceu a senha clique na tecla '1'");
            String senha = sc.next();
            if (verificarUser(email,senha)) {
                System.out.println("Seja bem-vindo(a) Sr(a) " + DadosUsers.getDataPessoa().get(email).getFirst() + " a Bibliotech !");
            } else if (senha.equals("1")) {
                recuperarSenha();
            }else {
                System.out.println("Email ou Senha invalidos, Tente novamente !!!");
            }
        }

        System.out.println("Voce errou 3 seus dados, volte e faça seu cadastro novamente.\n\n");
        typeUser();
    }

    public static boolean verificarUser(String email, String senha){
        return DadosUsers.getDataPessoa().get(email).contains(senha);
    }

    public static void typeUser (){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Qual tipo de usuario voce é ?
                
                [1] - ADM
                [2] - Usuário Comum
                
                """);
        int tipo = sc.nextInt();
        if (tipo == 1) {
            tipoUser = nivelAcesso.ADM;
            secundario();
        } else if (tipo == 2) {
            tipoUser = nivelAcesso.USER;
        }else {
            System.out.println("Tipo de usuario inexistente, Tente novamente !!!");
            typeUser();
        }
    }

    public static void recuperarSenha(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                -------------- Recuperação Senha --------------
                Informe seu email:
                """);
        String email = sc.next();

        for (int i = 0; i <= 3; i++) {
            if (DadosUsers.getDataPessoa().containsKey(email)){
                for (int t = 0; t <= 3; t++) {
                    System.out.println("Informe sua data de nascimento: \n\nObs: Sem traços (-) ou barra (/), somente números");
                    String date = sc.next();
                    if (DadosUsers.getDataPessoa().get(email).contains(date)){
                        System.out.print("Informe sua nova senha: ");
                        String novaSenha = sc.next();
                        DadosUsers.getDataPessoa().get(email).set(1,novaSenha);
                        System.out.println("Senha Alterado com sucesso !!!\n\nVocê será redirecionado para a area de login.");
                        secundario();
                    }else {
                        System.out.println("Data de nascimento não localidados, tente novamente !!!\n\n"+(t==3?(3-t)+" Tentativa(s) restante(s)":"Acabou suas tentativas"));
                    }
                }
            }else {
                System.out.printf("Email não localizado, tente novamente %s !!!",(i==3?" mais tarde":""));
            }
        }

    }
}


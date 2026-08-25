package cadastro;

import java.util.ArrayList;
import java.util.Scanner;
import armazenamento.*;
import validator.*;

public class CadUsuario extends Cadastrar{

    private static String emailUsuario;
    // Esse atributo permitirá conhecer qual usuario está ativo.

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Para darmos seguimento precisamos do seus dados pessoais\n\nInforme seu nome:");
        String nome = sc.nextLine();

        System.out.println("Qual é a seu email:");
        String email = sc.next();
        if (DadosUsers.getDataPessoa().containsKey(email)){
            System.out.println("Esse email já está cadastro no nosso sitema, tente fazer o login.");
            Autenticator.secundario();
        }
        emailUsuario = email; //Essa variavel representará o usuario ativo no sistema

        System.out.println("Informe sua data de nascimento: \n\nObs: não insira traço (-) nem barras (/).");
        String data = sc.next();

        System.out.println("""
                    \n\nAgora para terminar o seu cadastro preciso que crie um
                    senha para o seu login, pois o sistema irá armazenar
                    seu dados, e caso precise editar alguma informação pelo
                    seu login e senha, você consegue fazer essas 
                    modificações no sistema.
                    \n""");
        String senha;

        // Verificação de senha.
        while (true){
            System.out.println("informe sua nova senha:");
            senha = sc.next();

            System.out.println("informe sua nova senha:\nObs: Senha deve esta exatamento igual da etapa anterior.");
            String confirmSenha = sc.next();
            if (senha.equals(confirmSenha)){
                System.out.println("Senha criada com Sucesso !!!");
                break;
            }else{
                System.out.println("As senhas não se coincidem, tente novamente !!!");
            }
        }
        DadosUsers.getDataPessoa().put(email, new ArrayList<String>());
        DadosUsers.getDataPessoa().get(email).add(nome);
        DadosUsers.getDataPessoa().get(email).add(senha);
        DadosUsers.getDataPessoa().get(email).add(data);

        System.out.println("Usuário "+nome+", foi criado com sucesso !!!");
    }

    @Override
    public void remover(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                Você tem certeza qu""e deseja excluir o seu usuário do sistema !!!
                [y] - Sim
                [n] - Não
                :
                """);
        String escolha = sc.next().toLowerCase();

        if (escolha.equals("y")){
            DadosUsers.getDataPessoa().remove(emailUsuario);
            emailUsuario = ""; // apagando usuario ativo
            System.out.println("Seu perfil foi excluído com sucesso !!!");
        } else if (escolha.equals("n")) {
            System.out.println("Opção cancelado");
        }else {
            System.out.println("Opção Invalida !!!");
            System.out.println("Tente novamente !!!");
            remover();
        }
    }

    public static void setEmailUsuario(String novoEmailUsuario) {
        emailUsuario = novoEmailUsuario;
    }

    public static String getEmailUsuario() {
        return emailUsuario;
    }
}
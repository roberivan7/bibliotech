package cadastro;

import java.util.ArrayList;
import java.util.Scanner;
import armazenamento.*;
import validator.*;

public class CadUsuario extends Cadastrar{

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Para darmos seguimento precisamos do seus dados pessoais\n\nInforme seu nome:");
        String nome = sc.nextLine();

        System.out.println("Qual é a seu email:");
        String email = sc.next();

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
    }

    @Override
    public void editar(String item) {
        System.out.println("Editar");
    }

    @Override
    public void remover(String item) {
        System.out.println("Removendo");
    }

//    public static void addUsuario(String nome, String cpf, String email, String senha){
//        dataPessoa.put(email,new ArrayList<>());
//        dataPessoa.get(email).add(cpf);
//        dataPessoa.get(email).add(email);
//        dataPessoa.get(email).add(senha);
//        dataPessoa.get(email).add(nome);
//        System.out.println("Dados adicionado com sucesso !!!");
//        // cpf -> posição 0 | email -> posição 1 | senha -> posição 2 | nome -> posição 3
//    }

}
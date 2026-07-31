package program;

import java.util.*;

public class cadastro {
    public static void cadastroUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Para darmos seguimento precisamos do seus dados pessoais\n\nInforme seu nome:");
        String nome = sc.nextLine();
        System.out.println("Qual é a sua idade:");
        int idade = sc.nextInt();
        System.out.println("Qual é a seu CPF\nObs: Sem pontos e hífen.");
        String cpf = sc.next();
        if (cpf.equals("")) {
            System.out.println("Você já tem cadastro conosco, tente novamente \no login trocando sua senha de acesso");
            start.inicio();
        }
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
        dados.addUsuario(nome,cpf,email,senha);
        start.secundario();
    }
}
package bibliotech.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import bibliotech.*;
import bibliotech.cadastro.Biblioteca;
import bibliotech.cadastro.CadUsuario;
import bibliotech.validator.Autenticator;

public class Menu {
    public static void menuPrincipal() {
        Biblioteca blitech = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        if(Autenticator.nivelAcesso(CadUsuario.getEmailUsuario()).equals("ADM")){
            System.out.println("""
                                --------------- MENU ---------------
                                [1] - Acervo
                                [2] - Editar Livros
                                [3] - Adicionar Livros
                                [4] - Pegar Livro
                                [5] - Devolver Livro
                                [6] - Sair
                    """);
        }else if(Autenticator.nivelAcesso(CadUsuario.getEmailUsuario()).equals("USER")) {
            System.out.println("""
                                --------------- MENU ---------------
                                [1] - Acervo
                                [2] - Pegar Livro
                                [3] - Devolver Livro
                                [4] - Sair
                    """);
        }else{
            System.out.println("O retorno veio com algum erro, conserte !!!");
        }
        try {
            int acao = sc.nextInt();
            if(Autenticator.nivelAcesso(CadUsuario.getEmailUsuario()).equals("ADM")){
                switch (acao) {
                    case 1 -> Biblioteca.acervo();
                    case 2 -> blitech.editar();
                    case 3 -> blitech.add();
                    case 4 -> System.out.println("Não tem ainda");// ainda falta
                    case 5 -> System.out.println("Não tem nada ainda");// ainda falta
                    case 6 -> System.out.println("Tchau ! Até a Próxima");
                    default -> {
                        System.out.println("Valor invalido, tente novamente");
                        menuPrincipal();
                    }
                }
            }else {
                switch (acao) {
                    case 1 -> Biblioteca.acervo();
                    case 2 -> System.out.println("Não tem ainda");// ainda falta
                    case 3 -> System.out.println("Não tem nada ainda");// ainda falta
                    case 4 -> System.out.println("Tchau ! Até a Próxima");
                    default -> {
                        System.out.println("Valor invalido, tente novamente");
                        menuPrincipal();
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Tente novamente, não insira caracteres");
            menuPrincipal();
        }
    }
}
package bibliotech.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import bibliotech.*;
import bibliotech.cadastro.Biblioteca;

public class Menu {
    public static void menuPrincipal() {
        Biblioteca blitech = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                            --------------- MENU ---------------
                            [1] - Acervo
                            [2] - Editar Livros
                            [3] - Adicionar Livros
                            [4] - Pegar Livro
                            [5] - Devolver Livro
                """);
        try {
            int acao = sc.nextInt();
            switch (acao) {
                case 1 -> Biblioteca.acervo();
                case 2 -> blitech.editar();
                case 3 -> blitech.add();
                case 4 -> System.out.println("Não tem ainda");// ainda falta
                case 5 -> System.out.println("Não tem nada ainda");// ainda falta
                default -> {
                    System.out.println("Valor invalido, tente novamente");
                    menuPrincipal();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Tente novamente, não insira caracteres");
            menuPrincipal();
        }
    }
}
package bibliotech.menu;

import java.util.Scanner;
import bibliotech.*;
import bibliotech.cadastro.Biblioteca;

public class Menu {
    public static int menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                    --------------- MENU ---------------
                    [1] - Acervo
                    [2] - Editar Livros
                    [3] - Adicionar Livros
                    [4] - Pegar Livro
                    [5] - Devolver Livro
        """);

        int escolha = sc.nextInt();
        if(escolha == 0 || escolha > 5){
            System.out.println("Valor inválido !!!, Tente novamente !!!");
            menuPrincipal();
        }else{
            System.out.println("Caracteres não são opções !!! -- Tente novamente !");
        }
        return escolha;
    }

    public static void execucao(int acao){
        Biblioteca blitech = new Biblioteca();
        switch (acao){
            case 1:
                Biblioteca.acervo();
            case 2:
                blitech.editar();
            case 3:
                blitech.add();
            case 4:
                // ainda falta
            case 5:
                // ainda falta
        }
    }
}

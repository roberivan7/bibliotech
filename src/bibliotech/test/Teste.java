package bibliotech.test;
import bibliotech.cadastro.Biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Teste {
    private static HashMap<String, ArrayList<String>> livro = new HashMap();
        // 0 -> Autor | 1 -> genero | 2 -> id | 3 -> ano

    public enum Genero {
        TECNOLOGIA,
        POESIA,
        ROMANCE,
        FILOSOFIA,
        HISTORIA,
        BIOGRAFIA,
        DRAMA,
        SUSPENSE,
        MANGA
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Genero genero = null;
        while (true) {
            System.out.println("""
                            Informe o digito do genero abaixo:
                            [1] - TECNOLOGIA,
                            [2] - POESIA
                            [3] - ROMANCE
                            [4] - FILOSOFIA
                            [5] - HISTORIA
                            [6] - BIOGRAFIA
                            [7] - DRAMA
                            [8] - SUSPENSE
                            [9] - MANGA
                    """);
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1 -> genero = Genero.TECNOLOGIA;
                case 2 -> genero = Genero.ROMANCE;
                case 3 -> genero = Genero.DRAMA;
                default -> System.out.println("Informe um valor valido.");
            }
            if(genero != null) break;
        }
        System.out.println(genero);
    }
}


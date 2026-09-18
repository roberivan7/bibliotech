package bibliotech.test;
import bibliotech.cadastro.Biblioteca;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Teste {
    static void main() {
        System.out.println(resultado(5));
    }

    public static String resultado(int escolha) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe sua idade:");
        String a = sc.next();
        switch (a){
            case "1" -> System.out.println("ok");
            default -> System.out.println("Erro, Tente novamente");
        }
        return a;
    }
}


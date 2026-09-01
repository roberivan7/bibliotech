package bibliotech.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Teste {
    private static HashMap<String, ArrayList<String>> livro = new HashMap();
        // 0 -> Autor | 1 -> genero | 2 -> id | 3 -> ano

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        livro.put("David", new ArrayList<>());
        livro.get("David").add("nomeLivro");
        livro.get("David").add("genero");
        livro.get("David").add("codigo");
        livro.get("David").add("ano");
        System.out.println("\n\nLivro Adicionado com Sucesso !!!\n\n");
        livro.put("Roberivan", new ArrayList<>());
        livro.get("Roberivan").add("nomeLivro 10");
        livro.get("Roberivan").add("genero");
        livro.get("Roberivan").add("codigo 10");
        livro.get("Roberivan").add("ano 10");
        System.out.println("\n\nLivro Adicionado com Sucesso !!!\n\n");
        livro.put("Luis", new ArrayList<>());
        livro.get("Luis").add("nomeLivro 20");
        livro.get("Luis").add("genero");
        livro.get("Luis").add("codigo 20");
        livro.get("Luis").add("ano 20");
        System.out.println("\n\nLivro Adicionado com Sucesso !!!\n\n");

        System.out.println(livro.get("Roberivan"));
        System.out.println("Infome um novo nome: ");
        String novo = sc.next();
        livro.put(novo,livro.remove("Roberivan"));
        System.out.println(livro.get(novo));
        System.out.println(livro);
    }
}


package test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Spliterator;

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

        System.out.println("Buscar");
        String buscar = sc.nextLine();

        for (String buscando : livro.keySet()){
            if (buscar.equals(buscando)){
                System.out.println("Autor: "+buscando);
                System.out.println("Livro: "+livro.get(buscando).get(0));
                System.out.println("Genero: "+livro.get(buscando).get(1));
                System.out.println("Codigo: "+livro.get(buscando).get(2));
                System.out.println("Ano: "+livro.get(buscando).get(3));
//                for (int i = 0;i < livro.get(buscando).size(); i++) {
//                    System.out.println(livro.get(buscando).get(i));
//                }
            }
        }
        for (String autor: livro.keySet()){
            if (livro.get(autor).contains(buscar)){
                System.out.println("Autor: "+autor);
                System.out.println("Livro: "+livro.get(autor).get(0));
                System.out.println("Genero: "+livro.get(autor).get(1));
                System.out.println("Codigo: "+livro.get(autor).get(2));
                System.out.println("Ano: "+livro.get(autor).get(3));
            }
        }
        System.out.println(livro.get("Roberivan").contains("genero 10"));

        System.out.println("Voce quer alterar um livro:");
        String novo = sc.next();

        livro.get("Roberivan").set(0,novo);
        System.out.println(livro.get("Roberivan"));


    }
}


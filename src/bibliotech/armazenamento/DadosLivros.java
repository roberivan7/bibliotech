package bibliotech.armazenamento;

import java.util.*;

public class DadosLivros {
    private static HashMap<String, ArrayList<String>> dataLivro = new HashMap<>();

    public static HashMap<String, ArrayList<String>> getDataLivro(){return dataLivro;}

    public static void buscarLivro(String livro){
        for (String buscar: dataLivro.keySet()){
            if (livro.equals(buscar)){
            // Buscar por autor
                System.out.println("Autor: "+buscar);
                System.out.println("Título: "+dataLivro.get(buscar).get(0));
                System.out.println("Genero: "+dataLivro.get(buscar).get(1));
                System.out.println("Codigo: "+dataLivro.get(buscar).get(2));
                System.out.println("Ano: "+dataLivro.get(buscar).get(3)+"\n");
                System.out.println(" ----------------- \n\n");
            }else if(dataLivro.get(buscar).contains(livro)){
            // Buscar por Genero, Codigo, Titulo e Ano
                System.out.println("Autor: "+buscar);
                System.out.println("Título: "+dataLivro.get(buscar).get(0));
                System.out.println("Genero: "+dataLivro.get(buscar).get(1));
                System.out.println("Codigo: "+dataLivro.get(buscar).get(2));
                System.out.println("Ano: "+dataLivro.get(buscar).get(3)+"\n");
                System.out.println(" ----------------- \n\n");
            }else{
                System.out.println("Livro não cadastrado !!!");
            }
        }
    }
}
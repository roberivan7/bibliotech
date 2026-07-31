package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Spliterator;

public class biblioteca {
    private static HashMap<String, ArrayList<String>> livro = new HashMap();
    // 0 -> Autor | 1 -> genero | 2 -> id | 3 -> ano

    public static void acervo(){
        System.out.println(" id  |    Nome_do_Livro |     Autor    |   Gênero     |   Codigo   |  ano");
        ArrayList<String> nameBook = new ArrayList<>();
        Spliterator<String> nomesDados = livro.keySet().spliterator();
        nomesDados.forEachRemaining(nomes -> {nameBook.add(nomes);});
        for (int i = 0; i < livro.size(); i++) {
            System.out.printf(" %d  |    %s |     %s    |   %s     |   %s   |  %s%n",i,nameBook.get(i),livro.get(nameBook.get(i)).getFirst(),livro.get(nameBook.get(i)).get(1),livro.get(nameBook.get(i)).get(2),livro.get(nameBook.get(i)).get(3));
        }
    }

    public static void addLivro(String nomeLivro, String autor, String genero, String codigo, String ano){
        livro.put(autor, new ArrayList<>());
        livro.get(autor).add(nomeLivro);
        livro.get(autor).add(genero);
        livro.get(autor).add(codigo);
        livro.get(autor).add(ano);
        System.out.println("\n\nLivro Adicionado com Sucesso !!!\n\n");
    }

}

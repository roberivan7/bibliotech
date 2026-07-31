package test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Spliterator;

public class Teste {
    private HashMap<String, ArrayList<String>> livro = new HashMap();
        // 0 -> Autor | 1 -> genero | 2 -> id | 3 -> ano

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> livro = new HashMap();
        livro.put("Elias Amorim", new ArrayList<>());
        livro.get("Elias Amorim").add("Cabelos Molhados");
        livro.get("Elias Amorim").add("Romance");
        livro.get("Elias Amorim").add("D350");
        livro.get("Elias Amorim").add("2022");
        livro.put("David Goggins", new ArrayList<>());
        livro.get("David Goggins").add("Nada pode me ferir");
        livro.get("David Goggins").add("Biografia");
        livro.get("David Goggins").add("F878");
        livro.get("David Goggins").add("2018");

        System.out.println(" id  |  Autor   |     Nome_do_Livro    |   Gênero     |   Codigo   |  ano");
        ArrayList<String> nameBook = new ArrayList<>();
        Spliterator<String> nomesDados = livro.keySet().spliterator();
        nomesDados.forEachRemaining(nomes -> {nameBook.add(nomes);});
        for (int i = 0; i < livro.size(); i++) {
            System.out.printf(" %d  |    %s |     %s    |   %s     |   %s   |  %s%n",i,nameBook.get(i),livro.get(nameBook.get(i)).getFirst(),livro.get(nameBook.get(i)).get(1),livro.get(nameBook.get(i)).get(2),livro.get(nameBook.get(i)).get(3));
        }
    }
}

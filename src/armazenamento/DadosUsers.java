package armazenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DadosUsers {
    private static HashMap<String, ArrayList<String>> dataPessoa = new HashMap<>();
    private static HashSet<String> nomes = new HashSet<>();
    public static void addNomes(String nome) {
        nomes.add(nome);
    }
    public static boolean verificarUser(String email, String senha){
        return dataPessoa.get(email).contains(senha) && dataPessoa.get(email).contains(email);
    }

}

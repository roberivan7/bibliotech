package program;

import java.util.*;

public class dados {
    private static HashMap<String, ArrayList<String>> data = new HashMap<>();
    private static HashSet<String> nomes = new HashSet<>();

    public static void addUsuario(String nome, String cpf, String email, String senha){
            data.put(email,new ArrayList<>());
            data.get(email).add(cpf);
            data.get(email).add(email);
            data.get(email).add(senha);
            data.get(email).add(nome);
            System.out.println("Dados adicionado com sucesso !!!");
        // cpf -> posição 0 | email -> posição 1 | senha -> posição 2 | nome -> posição 3
    }

    public static void getNomes(String nome) {
        nomes.add(nome);
    }

    public static boolean verificarUser(String email, String senha){
        return data.get(email).contains(senha) && data.get(email).contains(email);
    }
}

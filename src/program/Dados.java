package program;

import java.util.*;

public class Dados {
    private static HashMap<String, ArrayList<String>> dataPessoa = new HashMap<>();
    private static HashMap<String, ArrayList<String>> dataLivro = new HashMap<>();
    private static HashSet<String> nomes = new HashSet<>();

    public HashMap<String, ArrayList<String>> getDataPessoa(){
        return dataPessoa;
    }

    public HashMap<String, ArrayList<String>> getDataLivro(){
        return dataLivro;
    }

    public static void addUsuario(String nome, String cpf, String email, String senha){
            dataPessoa.put(email,new ArrayList<>());
            dataPessoa.get(email).add(cpf);
            dataPessoa.get(email).add(email);
            dataPessoa.get(email).add(senha);
            dataPessoa.get(email).add(nome);
            System.out.println("Dados adicionado com sucesso !!!");
        // cpf -> posição 0 | email -> posição 1 | senha -> posição 2 | nome -> posição 3
    }

    public static void addNomes(String nome) {
        nomes.add(nome);
    }

    public static boolean verificarUser(String email, String senha){
        return dataPessoa.get(email).contains(senha) && dataPessoa.get(email).contains(email);
    }
}

package armazenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DadosUsers {
    private static HashMap<String, ArrayList<String>> dataPessoa = new HashMap<>();
    // key - Email | 0 - Nome | 1 - Senha

    public static HashMap<String,ArrayList<String>> getDataPessoa(){
        return dataPessoa;
    }
}

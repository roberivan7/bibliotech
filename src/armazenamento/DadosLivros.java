package armazenamento;

import java.util.*;

public class DadosLivros {
    private static HashMap<String, ArrayList<String>> dataLivro = new HashMap<>();

    public static HashMap<String, ArrayList<String>> getDataLivro(){return dataLivro;}
}
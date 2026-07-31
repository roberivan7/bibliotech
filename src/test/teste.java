package test;
import java.util.ArrayList;
import java.util.HashMap;

public class teste {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> dados = new HashMap<>();
//        dados.put("email",new ArrayList<>());
//        dados.get("email").add("roberivan@gmail.com");
        System.out.println(dados);
        try {
            System.out.println(dados.get("email").contains("roberivan@gmail.com"));
        }catch (NullPointerException e) {
            System.out.println("ArrayList esta vazio, error !!!");
        }
    }
}

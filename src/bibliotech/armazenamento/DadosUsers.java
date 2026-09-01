package bibliotech.armazenamento;

import java.util.ArrayList;
import java.util.HashMap;

public class DadosUsers {

    public static nivelAcesso tipoUser;
    private static String nome;
    private static String email;
    private static String senha;
    private static String cpf;

    public DadosUsers(String nome, String email, String senha, String cpf){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        tipoUser = nivelAcesso.ADM;
        getDataPessoa().put(email, new ArrayList<Object>());
        getDataPessoa().get(email).add(nome);
        getDataPessoa().get(email).add(senha);
        getDataPessoa().get(email).add(cpf);
        getDataPessoa().get(email).add(tipoUser);
    }

    public DadosUsers(){}

    public enum nivelAcesso {
        ADM,
        USER
    }

    private static HashMap<String, ArrayList<Object>> dataPessoa = new HashMap<>();
    // key - Email | 0 - Nome | 1 - Senha | 2 - cpf | 3 - Nivel de Acesso

    public static HashMap<String,ArrayList<Object>> getDataPessoa(){
        return dataPessoa;
    }

}

package bibliotech.cadastro;

import java.util.*;
import bibliotech.armazenamento.DadosLivros;
import bibliotech.armazenamento.DadosUsers;

public class Biblioteca extends Cadastrar {

    public enum statusLivro {
        EMPRESTADO,
        DISPONIVEL,
        EM_FALTA
    }

    public enum Genero {
        TECNOLOGIA,
        POESIA,
        ROMANCE,
        FILOSOFIA,
        HISTORIA,
        BIOGRAFIA,
        DRAMA,
        SUSPENSE,
        MANGA
    }

    public static void acervo(){
        Scanner sc = new Scanner(System.in);
        Biblioteca bio = new Biblioteca();
        if(DadosLivros.getDataLivro().isEmpty()){
            System.out.println("@@@ Nenhum Livro adicionado @@@");
            System.out.println("""
                    Voce deseja adicionar um livro ?
                    [1] - Sim
                    [2] - Não
                    """);
            int choice = sc.nextInt();
            if (choice==1) { bio.add();}
            else if (choice == 2) { sc.close(); }
            else {
                System.out.println("Valor invalidado, tente Novamente !!!");
                acervo();
            }
        }else {
            System.out.println(" id  |  Titulo  |    Autor    |   Gênero     |   Codigo   |  ano  | Quantidade  | Status ");
            ArrayList<String> nameBook = new ArrayList<>();
            Spliterator<String> nomesDados = DadosLivros.getDataLivro().keySet().spliterator();
            nomesDados.forEachRemaining(nomes -> {nameBook.add(nomes);});
            for (int i = 0; i < DadosLivros.getDataLivro().size(); i++) {
                System.out.printf("     %d      |     %s      |     %s      |     %s      |     %s      |     %s      |     %s      |     %s%n      ",i,nameBook.get(i),DadosLivros.getDataLivro().get(nameBook.get(i)).getFirst(),DadosLivros.getDataLivro().get(nameBook.get(i)).get(1),DadosLivros.getDataLivro().get(nameBook.get(i)).get(2),DadosLivros.getDataLivro().get(nameBook.get(i)).get(3),DadosLivros.getDataLivro().get(nameBook.get(i)).get(4),Integer.parseInt(DadosLivros.getDataLivro().get(nameBook.get(i)).get(4)) == 0 ? "Indisponível":"Disponível");
            }
        }

        System.out.println("""                
                --------- Solicitar Empretismo ---------
                [y] - Sim
                [n] - Não
                """);
        String choice = sc.next().toLowerCase();

        if (choice.equals("y")) emprestimo();
        else if (choice.equals("n")) System.out.println("Acervo Finalizado !!!");
        else System.out.println("Opção não reconhecida !!!");
    }

    @Override
    public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o Título do Livro: ");
        String nomeLivro = sc.nextLine();
        System.out.print("Informe o nome do Autor: ");
        String autor = sc.nextLine();
        Genero genero = null;
        while(true){
            System.out.println("""
                    Informe o digito do genero abaixo:
                    [1] - TECNOLOGIA,
                    [2] - POESIA
                    [3] - ROMANCE
                    [4] - FILOSOFIA
                    [5] - HISTORIA
                    [6] - BIOGRAFIA
                    [7] - DRAMA
                    [8] - SUSPENSE
                    [9] - MANGA
            """);
            int escolha = sc.nextInt();
            switch (escolha){
                case 1 -> genero = Genero.TECNOLOGIA;
                case 2 -> genero = Genero.POESIA;
                case 3 -> genero = Genero.ROMANCE;
                case 4 -> genero = Genero.FILOSOFIA;
                case 5 -> genero = Genero.HISTORIA;
                case 6 -> genero = Genero.BIOGRAFIA;
                case 7 -> genero = Genero.DRAMA;
                case 8 -> genero = Genero.SUSPENSE;
                case 9 -> genero = Genero.MANGA;
                default -> System.out.println("Informe um valor valido");
            }
            if(genero != null) break; // verificação de quebra do while
        }
        System.out.print("Informe o Codigo: ");
        String codigo = sc.next();
        System.out.print("Informe o Ano: "); // A devolutiva desse print deve ser um data mesmo, depois foco nisso
        String ano = sc.next();
        System.out.print("Informe a quantidade: "); // A devolutiva desse print deve ser um data mesmo, depois foco nisso
        String quantidade = sc.next(); // ira receber String por conta do arraylist ira receber String no Dados Livros

        DadosLivros.getDataLivro().put(nomeLivro, new ArrayList<>());
        DadosLivros.getDataLivro().get(nomeLivro).add(autor);
        DadosLivros.getDataLivro().get(nomeLivro).add(genero.toString());
        DadosLivros.getDataLivro().get(nomeLivro).add(codigo.toUpperCase());
        DadosLivros.getDataLivro().get(nomeLivro).add(ano);
        DadosLivros.getDataLivro().get(nomeLivro).add(quantidade);
        if(DadosLivros.getDataLivro().get(nomeLivro).get(4).equals("0")){
            String status = "Indisponivel";
            DadosLivros.getDataLivro().get(nomeLivro).add(status);
        }else {
            String status = "Disponivel";
            DadosLivros.getDataLivro().get(nomeLivro).add(status);
        }
        System.out.println("\n\nLivro Adicionado com Sucesso !!!\n\n");
    }

    @Override
    public void remover() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o codigo do livro para a exclusão:");
        acervo();
        String codigo = sc.next().toUpperCase();
        for (String buscar : DadosLivros.getDataLivro().keySet()) {
            if (DadosLivros.getDataLivro().get(buscar).get(2).equals(codigo)){
                System.out.printf("""
                Você realmente deseja excluir o livro: %s ?
                Você tem certeza que deseja excluir o seu usuário do sistema !!!
                [y] - Sim
                [n] - Não
                :
                """,buscar);
                String opcao = sc.next();
                if (opcao.equals("y")){
                    DadosLivros.getDataLivro().remove(buscar);
                    System.out.println("Livro removido com sucesso !!!");
                }else if (opcao.equals("n")){
                    System.out.println("Opção cancelada");
                }else{
                    System.out.println("Informação Invalida, Tente Novamente !!!!");
                    remover();
                }
                break;
            }
        }
    }

    @Override
    public void editar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual livro deseja editar:\n");
        Biblioteca.acervo();
        System.out.println("\nInforme o código do livro que deseja editar:");
        String codigo = sc.next().toUpperCase();
        System.out.println("  Dados do livro atual: \n\nTitulo  |    Autor    |   Gênero     |   Codigo   |  ano  | Quantidade");
        for (String buscar : DadosLivros.getDataLivro().keySet()) {
            if (DadosLivros.getDataLivro().get(buscar).get(2).equals(codigo)) {
                for (int i = 0; i < DadosLivros.getDataLivro().get(buscar).size(); i++) {
                    System.out.printf(" %s  |    %s |     %s    |   %s     |   %s   |  %s%n",buscar,DadosLivros.getDataLivro().get(buscar).getFirst(), DadosLivros.getDataLivro().get(buscar).get(1),DadosLivros.getDataLivro().get(buscar).get(2),DadosLivros.getDataLivro().get(buscar).get(3),DadosLivros.getDataLivro().get(buscar).get(4));
                }
            }
            System.out.println("""
                    O que voce deseja alterar nos dados do livro:
                    [t] - Titulo
                    [a] - Autor
                    [g] - Genero
                    [y] - Ano
                    [q] - Quantidade
                    """);
            String escolha = sc.next();
            do {
                if (escolha.equals("t")){
                    System.out.println("Informe um novo Titulo:");
    //                String novo = sc.next();
                    DadosLivros.getDataLivro().put(sc.next(),DadosLivros.getDataLivro().remove(buscar)); // Esse linha seria para remover a chave antiga e deixar os valores dentro da chave nova.
                    System.out.println("Titulo alterado com sucesso !!!");
                }else if (escolha.equals("a")){
                    System.out.println("Informe um novo(a) Autor(a):");
                    String novo = sc.next();
                    DadosLivros.getDataLivro().get(buscar).set(0,novo);
                    System.out.println("Nome do Autor alterado com sucesso !!!");
                }else if (escolha.equals("g")) {
                    System.out.println("Informe um novo Genêro:");
                    String novo = sc.next();
                    DadosLivros.getDataLivro().get(buscar).set(1,novo);
                    System.out.println("Gênero alterado com sucesso !!!");
                }else if (escolha.equals("y")){
                    System.out.println("Informe um novo Ano:");
                    String novo = sc.next();
                    DadosLivros.getDataLivro().get(buscar).set(3,novo);
                    System.out.println("Ano alterado com sucesso !!!");
                }else if (escolha.equals("q")) {
                    System.out.println("Informe uma nova Quantidade:");
                    String novo = sc.next();
                    DadosLivros.getDataLivro().get(buscar).set(4,novo);
                    System.out.println("Quatidade alterado com sucesso !!!");
                }else {
                    System.out.println("Digito desconhecido, tente novamente");
                }
            } while (escolha.equals("t") || escolha.equals("a") || escolha.equals("g") || escolha.equals("y") || escolha.equals("q"));
        }
    }

    public static void emprestimo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o codigo do livro para emprestimo:");
        String codigo = sc.next();

        int tentativa = 1;
        for(String buscar : DadosLivros.getDataLivro().keySet()){
            if(Integer.parseInt(DadosLivros.getDataLivro().get(buscar).get(2)) >= 1){
                if(DadosLivros.getDataLivro().get(buscar).get(2).equals(codigo)) {
                    int qtd = Integer.parseInt(DadosLivros.getDataLivro().get(buscar).get(4))-1;
                    DadosLivros.getDataLivro().get(buscar).set(2,String.valueOf(qtd));
                    System.out.println("Livro Disponivel para emprestimo !!!");
                    break;
                } else if (tentativa == DadosLivros.getDataLivro().size()) {
                    System.out.println("""
                            Livro inexistente no acervo  !!!
                            
                            Deseja inserir outro codigo ?
                            [y] - Sim
                            [n] - Não
                            """);
                    if (sc.next().equals("y")) emprestimo();
                    else break;
                }else {tentativa++;}
            } else if (Integer.parseInt(DadosLivros.getDataLivro().get(buscar).get(2)) == 0 && DadosLivros.getDataLivro().get(buscar).get(2).equals(codigo)) {
                System.out.println("""
                        Livro indiposnivel no Acervo !!!
                        
                        Deseja inserir outro codigo ?
                        [y] - Sim
                        [n] - Não
                        """);
                if (sc.next().equals("y")) emprestimo();
                else break;
            }else {
                System.out.println("Livro");
            }
        }
    }
}
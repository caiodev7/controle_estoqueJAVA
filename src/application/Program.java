package application;

import entities.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> list = new ArrayList<>();

        int opcao = 0;

        while (opcao != 10) {

            System.out.println();
            System.out.println("====MENU====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Adicionar estoque");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Produtos com estoque baixo");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Remover estoque ");
            System.out.println("8 - Buscar produto por nome");
            System.out.println("9 - Produto mais caro ");
            System.out.println("10 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            switch (opcao) {

                case 1:

                    System.out.println("Id: ");
                    int id = sc.nextInt();

                    while (existeId(list, id)) {
                        System.out.println("Id já existente! Digite outro");
                        id = sc.nextInt();
                    }
                    sc.nextLine();

                    System.out.println("Nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Preço: ");
                    double preco = sc.nextDouble();

                    System.out.println("Quantidade: ");
                    int quantidade = sc.nextInt();

                    Produto produto = new Produto(id, nome, preco, quantidade);

                    list.add(produto);

                    System.out.println("Produto cadastrado!");

                    break;

                case 2:

                    System.out.println();
                    System.out.println("LISTA DE PRODUTOS: ");

                    if (list.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado! ");
                    } else {

                        for (Produto p : list) {
                            System.out.println(p);
                        }
                    }
                    break;


                case 3:

                    System.out.print("Digite o Id do produto: ");
                    id = sc.nextInt();

                    Integer pos = posicao(list, id);

                    if (pos == null) {
                        System.out.println("Produto não encontrado!");
                    } else {

                        System.out.println("Quantidade para adicionar: ");
                        quantidade = sc.nextInt();

                        list.get(pos).adicionarEstoque(quantidade);

                        System.out.println("Estoque atualizado! ");
                    }

                    break;

                case 4:

                    System.out.print("Digite o ID do produto: ");
                    id = sc.nextInt();

                    pos = posicao(list, id);

                    if (pos == null) {
                        System.out.println("Produto não encontrado !");
                    } else {

                        list.remove((int) pos);

                        System.out.println("Produto removido! ");

                    }

                    break;

                case 5:

                    System.out.println();
                    System.out.println("PRODUTOS COM ESTOQUE BAIXO: ");

                    boolean estoqueBaixo = false;

                    for (Produto p : list) {

                        if (p.getQuantidade() < 102) {
                            System.out.println(p);

                            estoqueBaixo = true;
                        }
                    }

                    if (!estoqueBaixo) {
                        System.out.println("Nenhum produto com estoque baixo!");
                    }
                    break;

                case 6:

                    System.out.print("Digite o ID do produto: ");
                    id = sc.nextInt();

                    pos = posicao(list, id);

                    if (pos == null) {
                        System.out.println("Produto não encontrado!");
                    } else {

                        System.out.print("Novo preço: ");
                        double novoPreco = sc.nextDouble();

                        list.get(pos).atualizarPreco(novoPreco);

                        System.out.println("Preço atualizado!");
                    }
                    break;

                case 7:

                    System.out.print("Digite o ID do produto: ");
                    id = sc.nextInt();

                    pos = posicao(list, id);

                    if (pos == null) {
                        System.out.println("Produto não encontrado");

                    } else {

                        System.out.println("Quantidade para remover: ");
                        quantidade = sc.nextInt();

                        list.get(pos).removerEstoque(quantidade);

                        System.out.println("Estoque atualizado! ");
                    }
                    break;

                case 8:

                    sc.nextLine();

                    System.out.println("Digite o nome do produto: ");
                    String busca = sc.nextLine();

                    boolean encontrado = false;

                    for (Produto p : list) {

                        if (p.getNome().equalsIgnoreCase(busca)) {

                            System.out.println(p);

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado! ");

                    }

                    break;

                case 9:

                    if (list.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado! ");
                    } else {

                        Produto maisCaro = list.get(0);

                        for (Produto p : list) {

                            if (p.getPreco() > maisCaro.getPreco()) {
                                maisCaro = p;
                            }
                        }

                        System.out.println("PRODUTO MAIS CARO: ");
                        System.out.println(maisCaro);
                    }

                    break;

                case 10:

                    System.out.println("Progama encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida! ");

            }
        }
        sc.close();
    }

    public static Integer posicao(List<Produto> list, int id) {
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getId() == id) {
                return i;

            }
        }
        return null;

    }

    public static boolean existeId(List<Produto> list, int id) {

        Produto produto = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        return produto != null;
    }
}


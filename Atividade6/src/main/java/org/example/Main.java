package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Produto> produtos = new HashMap<>();
        int opcao;

        // Exibi o menu e executar as opções até o usuário escolher sair
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Cadastro de produto
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    Produto produto = new Produto(codigo, nome, preco);
                    produtos.put(codigo, produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    // Busca de produto por código
                    System.out.print("Digite o código do produto para busca: ");
                    int codigoBusca = scanner.nextInt();
                    scanner.nextLine();

                    Produto produtoBuscado = produtos.get(codigoBusca);
                    if (produtoBuscado != null) {
                        System.out.println("Produto encontrado: " + produtoBuscado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}

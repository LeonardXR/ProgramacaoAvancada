package com.unicesumar;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.Sales;
import com.unicesumar.entities.User;
import com.unicesumar.paymentMethods.PaymentMethod;
import com.unicesumar.paymentMethods.PaymentType;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.SalesRepository;
import com.unicesumar.repository.UserRepository;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductRepository listaDeProdutos = null;
        UserRepository listaDeUsuarios = null;
        SalesRepository listaDeVendas = null;

        Connection conn = null;
        String url = "jdbc:sqlite:database.sqlite";

        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                listaDeProdutos = new ProductRepository(conn);
                listaDeUsuarios = new UserRepository(conn);
                listaDeVendas = new SalesRepository(conn);
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        int option = -1;
        boolean continuarSistema = true;

        while (continuarSistema) {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Registrar Vendas");
            System.out.println("6 - Comprar Produto");
            System.out.println("7 - Sair");
            System.out.print("\nEscolha uma opção: ");

            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Você digitou algo que não é um número.");
                System.out.print("Deseja continuar no sistema? (S/N): ");
                String resposta = scanner.nextLine().trim().toUpperCase();
                if (!resposta.equals("S")) {
                    break;
                } else {
                    continue;
                }
            }

            switch (option) {
                case 1:
                    System.out.println("\n---Cadastrar Produto---\n");
                    System.out.print("Nome do produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Preço do produto: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Product newProduct = new Product(name, price);
                    listaDeProdutos.save(newProduct);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n---Listar Produtos---\n");
                    List<Product> products = listaDeProdutos.findAll();
                    products.forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("\n---Cadastrar Usuário---\n");
                    System.out.print("Nome do usuário: ");
                    String nameUser = scanner.nextLine();
                    System.out.print("Email do usuário: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha do usuário: ");
                    String password = scanner.nextLine();
                    User newUser = new User(nameUser, email, password);
                    listaDeUsuarios.save(newUser);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.println("\n---Listar Usuários---\n");
                    List<User> users = listaDeUsuarios.findAll();
                    users.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("\n---Históricos de vendas---\n");
                    List<Sales> salesList = listaDeVendas.findAll();
                    for (Sales sale : salesList) {
                        System.out.println("Resumo da venda:");
                        System.out.println("Cliente: " + sale.getBuyer().getName());
                        System.out.println("Produtos:");
                        for (Product product : sale.getProducts()) {
                            System.out.println("- " + product.getName());
                        }
                        System.out.printf("Valor total: R$ %.2f%n", sale.getTotalValue());
                        System.out.println("Pagamento: " + sale.getPaymentMethod());
                        System.out.println("Chave de Autenticação: " + sale.getAuthCode());
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.print("Digite o Email do usuário: ");
                    String userEmail = scanner.nextLine();
                    Optional<User> userOpt = listaDeUsuarios.findByEmail(userEmail);
                    if (!userOpt.isPresent()) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }
                    User buyer = userOpt.get();
                    System.out.println("Usuário encontrado: " + buyer.getName());

                    List<Product> selectedProducts = new ArrayList<>();
                    while (true) {
                        System.out.print("Digite o UUID do produto que deseja adicionar: ");
                        String idStr = scanner.nextLine();
                        try {
                            UUID id = UUID.fromString(idStr.trim());
                            Optional<Product> product = listaDeProdutos.findById(id);
                            if (product.isPresent()) {
                                if (selectedProducts.contains(product.get())) {
                                    System.out.println("Esse produto já foi adicionado.");
                                } else {
                                    selectedProducts.add(product.get());
                                    System.out.println("Produto adicionado: " + product.get().getName());
                                }
                            } else {
                                System.out.println("Produto não encontrado para ID: " + idStr);
                            }
                        } catch (Exception e) {
                            System.out.println("ID inválido.");
                        }

                        System.out.print("Deseja adicionar mais produtos? (S/N): ");
                        String continuar = scanner.nextLine().trim().toUpperCase();
                        if (!continuar.equals("S")) {
                            break;
                        }
                    }

                    if (selectedProducts.isEmpty()) {
                        System.out.println("Nenhum produto válido selecionado.");
                        break;
                    }

                    System.out.println("\nProdutos encontrados:\n");
                    selectedProducts.forEach(p ->
                            System.out.printf("- %s (R$ %.2f)%n", p.getName(), p.getPrice())
                    );

                    double totalValue = selectedProducts.stream().mapToDouble(Product::getPrice).sum();
                    System.out.printf("Valor total da compra: R$ %.2f%n", totalValue);

                    PaymentType paymentType = null;
                    while (paymentType == null) {
                        System.out.println("Digite a forma de pagamento (PIX, BOLETO, CARTAO): ");
                        String paymentInput = scanner.nextLine().toUpperCase();
                        try {
                            paymentType = PaymentType.valueOf(paymentInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Forma de pagamento inválida. Tente novamente.");
                        }
                    }

                    System.out.println("Aguarde, efetuando pagamento...");
                    String authCode = UUID.randomUUID().toString();
                    System.out.println("Pagamento confirmado com sucesso via " + paymentType + ". Chave de Autenticação: " + authCode);

                    Sales sale = new Sales(UUID.randomUUID(), buyer, selectedProducts, totalValue, paymentType, authCode, LocalDateTime.now());
                    listaDeVendas.save(sale);

                    System.out.println("\nResumo da venda:");
                    System.out.println("Cliente: " + buyer.getName());
                    selectedProducts.forEach(p -> System.out.println("- " + p.getName()));
                    System.out.printf("Valor total: R$ %.2f%n", totalValue);
                    System.out.println("Pagamento: " + paymentType);
                    System.out.println("Venda registrada com sucesso");
                    break;

                case 7:
                    System.out.println("Saindo...");
                    continuarSistema = false;
                    break;

                default:
                    System.out.println("Opção inválida. Essa opção não existe no menu.");
                    System.out.print("Deseja continuar no sistema? (S/N): ");
                    String resposta = scanner.nextLine().trim().toUpperCase();
                    if (!resposta.equals("S")) {
                        continuarSistema = false;
                    }
                    break;
            }
        }

        scanner.close();

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

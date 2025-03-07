package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe as opções de notificação
        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: E-mail");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");

        // Coleta a escolha do usuário
        String opcao = scanner.nextLine();

        // Solicita a mensagem a ser enviada
        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();

        // Cria a instância da notificação usando a fábrica
        Notificacao notificacao = FabricaNotificacao.criarNotificacao(opcao);

        // Envia a mensagem
        notificacao.enviar(mensagem);

        scanner.close();
    }
}
package org.example;

// Fábrica para criar diferentes tipos de notificações.
public class FabricaNotificacao {

    // Cria uma notificação com base no tipo fornecido.
    public static Notificacao criarNotificacao(String tipo) {
        switch (tipo) {
            case "1": return new NotificacaoEmail();  // Notificação por e-mail
            case "2": return new NotificacaoSMS();    // Notificação por SMS
            case "3": return new NotificacaoPush();   // Notificação push
            default: throw new IllegalArgumentException("Tipo de notificação inválido.");
        }
    }
}
package org.example;

// Notificação push.
public class NotificacaoPush implements Notificacao {

    // Envia mensagem por notificação push.
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando Push Notification: " + mensagem);
    }
}

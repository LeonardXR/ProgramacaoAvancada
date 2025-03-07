package org.example;

// Notificação por SMS.
public class NotificacaoSMS implements Notificacao {

    // Envia mensagem por SMS.
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

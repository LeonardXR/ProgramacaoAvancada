package org.example;

// Notificação por e-mail.
public class NotificacaoEmail implements Notificacao {

    // Envia mensagem por e-mail.
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}
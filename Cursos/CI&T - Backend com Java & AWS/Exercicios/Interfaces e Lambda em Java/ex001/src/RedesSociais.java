public class RedesSociais implements MessageService {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Postando nas Redes Sociais: " + mensagem);

    }
}

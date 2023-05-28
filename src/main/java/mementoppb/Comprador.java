package observerppb;

import java.util.Observable;
import java.util.Observer;

public class Comprador implements Observer {
    private String nome;

    private String ultimaNotificacao ="Sem notificação";
    public Comprador(String nome){
        this.nome=nome;
    }
    public void participar(Leilao leilao) { leilao.addObserver(this); }
    public void darLance(Leilao leilao, double valor){
        leilao.ReceberLance(valor,nome);
    }

    @Override
    public void update(Observable leilao, Object arg) {
        this.ultimaNotificacao = leilao.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}

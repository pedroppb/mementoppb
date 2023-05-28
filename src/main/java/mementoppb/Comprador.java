package mementoppb;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Comprador implements Observer {
    private String nome;
    private String ultimaNotificacao ="Sem notificação";
    private List<String> memento = new ArrayList<String>();
    public Comprador(String nome){
        this.nome=nome;
        memento.add(ultimaNotificacao);
    }
    public void participar(Leilao leilao) {
        memento.remove(0);
        memento.add(nome+" está participando do leilao de: "+leilao.getNomeProduto());
        leilao.addObserver(this);
    }
    public void darLance(Leilao leilao, double valor){
        leilao.ReceberLance(valor,nome);
    }

    @Override
    public void update(Observable leilao, Object arg) {
        this.ultimaNotificacao = leilao.toString();
        memento.add(ultimaNotificacao);
    }
    public String historicoLances() {
        String historico="";
        for (String lance : memento ) {
            historico+=lance+"\n";
        }
        return historico;
    }

    public String getNome() {
        return nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}

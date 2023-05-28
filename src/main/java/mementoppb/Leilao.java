package mementoppb;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Leilao extends Observable {

    private Produto produto;
    private double ultimolance;
    private String ultimoComprador;
    private String ultimoEvento;
    private boolean leilaoAberto;
    private List<String> memento = new ArrayList<String>();
    public Leilao(Produto produto){
        this.produto=produto;
        ultimolance= produto.getValor();
        ultimoEvento= "leilao de: "+ produto.getNome()+" esta aberto com lance minimo de R$ "+ultimolance;
        memento.add(ultimoEvento);
        leilaoAberto=true;
    }
    public void ReceberLance(double lance, String comprador){
        if(lance >= ultimolance && leilaoAberto) {
            ultimoComprador=comprador;
            ultimolance=lance;
            ultimoEvento="Produto: " +produto.getNome()+" recebeu lance de por R$ "+ultimolance+" por "+ultimoComprador;
            memento.add(ultimoEvento);
            setChanged();
            notifyObservers();
        }
    }
    public void finalizarLeilao(){
        leilaoAberto=false;
        ultimoEvento = "Produto: " +produto.getNome()+ " vendido para " +ultimoComprador +" por R$ "+ultimolance;
        memento.add(ultimoEvento);
        setChanged();
        notifyObservers();
        deleteObservers();
    }
    public String historicoLeilao() {
        String historico="";
        for (String lance : memento ) {
            historico+=lance+"\n";
        }
        return historico;
    }
    public String getNomeProduto(){
        return produto.getNome();
    }

    @Override
    public String toString() { return this.ultimoEvento; }

}

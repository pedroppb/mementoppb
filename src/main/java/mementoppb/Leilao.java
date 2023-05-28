package observerppb;

import java.util.Observable;

public class Leilao extends Observable {

    private Produto produto;
    private double ultimolance;
    private String ultimoComprador;
    private String ultimoEvento;
    private boolean leilaoAberto;
    public Leilao(Produto produto){
        this.produto=produto;
        ultimolance= produto.getValor();
        ultimoEvento= "leilao de: "+ produto.getNome()+" esta aberto com lance minimo de R$ "+ultimolance;
        leilaoAberto=true;
    }
    public void ReceberLance(double lance, String comprador){
        if(lance > ultimolance && leilaoAberto) {
            ultimoComprador=comprador;
            ultimolance=lance;
            ultimoEvento="Produto: " +produto.getNome()+" recebeu lance de por R$ "+ultimolance+" por "+ultimoComprador;
            setChanged();
            notifyObservers();
        }
    }
    public void finalizarLeilao(){
        leilaoAberto=false;
        ultimoEvento = "Produto: " +produto.getNome()+ " vendido para " +ultimoComprador +" por R$ "+ultimolance;
        setChanged();
        notifyObservers();
        deleteObservers();
    }
    @Override
    public String toString() {
        return this.ultimoEvento;
    }

}

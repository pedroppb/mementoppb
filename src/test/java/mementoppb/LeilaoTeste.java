package mementoppb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LeilaoTeste {
    Produto produto = new Produto("camisa",50);
    Leilao leilao = new Leilao(produto);
    @Test
    void deveGerarHistoricoLeilao() {
        Produto produto = new Produto("camisa",50);
        Leilao leilao = new Leilao(produto);
        Comprador c1 = new Comprador("pedro");
        c1.participar(leilao);
        c1.darLance(leilao,60);
        leilao.finalizarLeilao();
        assertEquals("leilao de: camisa esta aberto com lance minimo de R$ 50.0\n" +
                "Produto: camisa recebeu lance de por R$ 60.0 por pedro\n" +
                "Produto: camisa vendido para pedro por R$ 60.0\n", leilao.historicoLeilao());
    }
    @Test
    void deveGerarHistoricoParticipante() {
        Produto produto = new Produto("camisa",50);
        Leilao leilao = new Leilao(produto);
        Comprador c1 = new Comprador("pedro");
        Comprador c2 = new Comprador("joão");
        c1.participar(leilao);
        c2.participar(leilao);
        c1.darLance(leilao,60);
        c2.darLance(leilao,80);
        c1.darLance(leilao,90);
        leilao.finalizarLeilao();
        assertEquals("pedro está participando do leilao de: camisa\n" +
                "Produto: camisa recebeu lance de por R$ 60.0 por pedro\n" +
                "Produto: camisa recebeu lance de por R$ 80.0 por joão\n" +
                "Produto: camisa recebeu lance de por R$ 90.0 por pedro\n" +
                "Produto: camisa vendido para pedro por R$ 90.0\n", c1.historicoLances());
    } @Test
    void naoDeveGerarHistoricoNaoParticipante() {
        Produto produto = new Produto("camisa",50);
        Leilao leilao = new Leilao(produto);
        Comprador c1 = new Comprador("pedro");
        Comprador c2 = new Comprador("joão");
        Comprador c3 = new Comprador("marcio");
        c1.participar(leilao);
        c2.participar(leilao);
        c1.darLance(leilao,60);
        c2.darLance(leilao,80);
        c1.darLance(leilao,90);
        leilao.finalizarLeilao();
        assertEquals("Sem notificação\n", c3.historicoLances());
    }

}

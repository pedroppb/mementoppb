package observerppb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LeilaoTeste {
    Produto produto = new Produto("camisa",50);
    Leilao leilao = new Leilao(produto);
    @Test
    void deveNotificarParticipante() {
        Produto produto = new Produto("camisa",50);
        Leilao leilao = new Leilao(produto);
        Comprador c1 = new Comprador("pedro");
        c1.participar(leilao);
        c1.darLance(leilao,60);
        leilao.finalizarLeilao();
        assertEquals("Produto: camisa vendido para pedro por R$ 60.0", c1.getUltimaNotificacao());
    }
    @Test
    void deveRetornarGanhadorParaParticipantes() {
        Produto produto = new Produto("camisa",50);
        Leilao leilao = new Leilao(produto);
        Comprador c1 = new Comprador("pedro");
        Comprador c2 = new Comprador("joão");
        c1.participar(leilao);
        c2.participar(leilao);
        c1.darLance(leilao,60);
        c2.darLance(leilao,80);
        leilao.finalizarLeilao();
        assertEquals("Produto: camisa vendido para joão por R$ 80.0", c1.getUltimaNotificacao());
        assertEquals("Produto: camisa vendido para joão por R$ 80.0", c2.getUltimaNotificacao());
    }
    @Test
    void deveNaoDeveRetornarGanhadorParaNaoParticipante() {
        Comprador c1 = new Comprador("pedro");
        Comprador c2 = new Comprador("joão");
        c1.participar(leilao);
        c1.darLance(leilao,60);
        leilao.finalizarLeilao();
        assertEquals("Produto: camisa vendido para pedro por R$ 60.0", c1.getUltimaNotificacao());
        assertEquals("Sem notificação", c2.getUltimaNotificacao());
    }
}

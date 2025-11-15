import java.util.ArrayList;
import java.util.List;

/**
 * Classe de domínio que representa um Pedido.
 * Esta classe demonstra a aplicação do padrão GRASP "Creator".
 */
public class Pedido {

    private List<ItemPedido> itens;
    private double total;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    /**
     * ########################################################################
     * JUSTIFICATIVA GRASP - CREATOR (Criador)
     * ########################################################################
     *
     * 1. Padrão Utilizado:
     * Creator (Criador).
     *
     * 2. Onde foi aplicado:
     * No método adicionarItem() da classe Pedido.
     *
     * 3. Por que atende ao princípio:
     * O padrão Creator define quem deve ser responsável por criar uma nova
     * instância de um objeto (B). Um objeto (A) deve criar (B) se:
     *
     * a) A "agrega" ou "contém" B.
     *
     * Neste caso, 'Pedido' (A) "agrega" 'ItemPedido' (B) em sua lista 'itens'.
     * Portanto, 'Pedido' é o candidato ideal para ter a responsabilidade
     * de criar instâncias de 'ItemPedido'.
     */
    public void adicionarItem(Produto produto, int quantidade) {
        // A própria classe Pedido cria a instância de ItemPedido
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        this.itens.add(novoItem);
        this.recalcularTotal();
    }

    private void recalcularTotal() {
        this.total = 0.0;
        for (ItemPedido item : this.itens) {
            this.total += item.calcularSubtotal();
        }
    }

    // Getters
    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }
}
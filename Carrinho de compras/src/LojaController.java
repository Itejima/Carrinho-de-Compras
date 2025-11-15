/**
 * ########################################################################
 * JUSTIFICATIVA GRASP - CONTROLLER (Controlador)
 * ########################################################################
 *
 * 1. Padrão Utilizado:
 * Controller (Controlador).
 *
 * 2. Onde foi aplicado:
 * A própria classe LojaController é a implementação do padrão.
 *
 * 3. Por que atende ao princípio:
 * O padrão Controller atua como um intermediário entre a camada de
 * apresentação (UI, simulada pela 'Main') e a camada de domínio ('Pedido').
 *
 * Esta classe recebe as "requisições" do sistema (ex: criar um pedido,
 * adicionar um produto) e DELEGA o trabalho para os objetos de
 * domínio apropriados (ex: chama 'pedido.adicionarItem(...)').
 *
 * Benefícios:
 * - Baixo Acoplamento (Low Coupling): A UI (Main) não precisa conhecer
 * internamente as classes Pedido ou ItemPedido. Ela só se
 * comunica com o Controller.
 */
public class LojaController {

    // Método que coordena a criação de um novo Pedido
    public Pedido criarNovoPedido() {
        System.out.println("[Controller] Recebida requisição para criar novo pedido.");
        return new Pedido();
    }

    // Método que coordena a adição de um item a um pedido
    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto, int quantidade) {
        System.out.printf("[Controller] Delegando adição de %d x %s ao pedido.\n",
                quantidade, produto.getNome());
        
        if (pedido != null && produto != null && quantidade > 0) {
            pedido.adicionarItem(produto, quantidade);
        }
    }

    // Método que coordena a exibição dos dados
    public void exibirResumoPedido(Pedido pedido) {
        System.out.println("\n--- Resumo do Pedido ---");
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("Produto: %s | Qtd: %d | Subtotal: R$ %.2f\n",
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.calcularSubtotal());
        }
        System.out.printf("TOTAL DO PEDIDO: R$ %.2f\n", pedido.getTotal());
    }
}
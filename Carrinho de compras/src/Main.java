/**
 * Classe principal para simular a execução do sistema.
 * Ela representa a "Camada de Apresentação" (UI).
 */
public class Main {
    public static void main(String[] args) {
        
        // 1. A UI (Main) conhece apenas o Controller
        LojaController controller = new LojaController();

        // 2. Dados do sistema
        Produto p1 = new Produto("Notebook Gamer", 5000.00);
        Produto p2 = new Produto("Mouse sem fio", 150.00);
        Produto p3 = new Produto("Teclado Mecânico", 350.00);

        // 3. A UI solicita ao Controller a criação de um pedido
        Pedido meuPedido = controller.criarNovoPedido();

        // 4. A UI solicita ao Controller a adição de itens
        controller.adicionarProdutoAoPedido(meuPedido, p1, 1);
        controller.adicionarProdutoAoPedido(meuPedido, p2, 2);
        controller.adicionarProdutoAoPedido(meuPedido, p3, 1);

        // 5. A UI solicita ao Controller a exibição do resultado
        controller.exibirResumoPedido(meuPedido);
    }
}
# Demonstração de Padrões GRASP em Java (Sistema de Carrinho de Compras)

Este projeto é uma aplicação Java simples desenvolvida como atividade acadêmica. O objetivo principal é demonstrar a aplicação prática de dois padrões **GRASP** (General Responsibility Assignment Software Patterns) para promover um bom design orientado a objetos.

O sistema simula um "Carrinho de Compras" básico, onde é possível criar um pedido e adicionar produtos a ele, calculando o total.

## 🚀 Tecnologias Utilizadas

* **Java** (JDK 11 ou superior)

## 🏛️ Estrutura do Projeto

O projeto é composto por 5 classes:

* `Produto.java`: Classe de entidade que representa um item vendável.
* `ItemPedido.java`: Classe que representa um produto dentro de um pedido (contém o produto e a quantidade).
* `Pedido.java`: Classe que agrega `ItemPedido`s e gerencia o total.
* `LojaController.java`: Classe que atua como intermediário entre a UI e o domínio.
* `Main.java`: Classe de execução que simula a "Interface do Usuário" (UI) fazendo requisições.

---

## 💡 Padrões GRASP Aplicados

O trabalho implementa e justifica os seguintes padrões GRASP:

### 1. Controller (Controlador)

Este padrão define quem deve ser responsável por receber e tratar eventos do sistema (geralmente vindos da camada de apresentação/UI).

* **Classe:** `LojaController.java`
* **Justificativa:** A classe `LojaController` foi criada para ser o único ponto de entrada para a "UI" (simulada pela classe `Main`). Ela recebe requisições como "criar um novo pedido" ou "adicionar um item".
* **Por que atende ao princípio:**
    * Ela **não faz o trabalho de negócio** sozinha; ela **delega** a responsabilidade para os objetos de domínio corretos (ex: `pedido.adicionarItem(...)`).
    * Isso promove **Baixo Acoplamento**, pois a classe `Main` não precisa conhecer as classes `Pedido` ou `ItemPedido`. Se a lógica de negócio mudar, a `Main` não sofre impacto.
    * Isso promove **Alta Coesão**, pois o `Controller` foca apenas em *coordenar* tarefas, enquanto o `Pedido` foca apenas em suas *regras de negócio*.

### 2. Creator (Criador)

Este padrão ajuda a decidir quem deve ter a responsabilidade de criar uma nova instância de um objeto.

* **Classe:** `Pedido.java`
* **Método:** `adicionarItem(Produto produto, int quantidade)`
* **Justificativa:** O padrão Creator sugere que a classe A deve criar a classe B se A "agrega" ou "contém" B.
* **Por que atende ao princípio:**
    * A classe `Pedido` possui uma `List<ItemPedido>`, ou seja, ela **agrega** (contém) instâncias de `ItemPedido`.
    * Portanto, a classe `Pedido` é a candidata ideal para ser responsável por instanciar (`new ItemPedido(...)`) os objetos `ItemPedido` que farão parte dela.
    * Isso centraliza a lógica de criação e adição, mantendo o encapsulamento e a coesão da classe `Pedido`.

---

## ⚙️ Como Executar

1.  Certifique-se de ter o **JDK (Java Development Kit)** instalado em sua máquina.
2.  Salve todas as 5 classes (`Produto.java`, `ItemPedido.java`, `Pedido.java`, `LojaController.java`, `Main.java`) em um mesmo diretório.
3.  Abra um terminal ou prompt de comando nesse diretório.
4.  Compile todos os arquivos `.java`:
    ```bash
    javac *.java
    ```
5.  Execute a classe principal `Main`:
    ```bash
    java Main
    ```

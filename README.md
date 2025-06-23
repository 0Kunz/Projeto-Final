## Descrição:

    - Este projeto é um sistema de gerenciamento de pedidos para uma lanchonete, desenvolvido em Java com interface gráfica utilizando Swing. O sistema permite que os clientes façam pedidos e que os funcionários gerenciem o status dos pedidos (em espera, em preparo e finalizados).

## Funcionalidades:

    Cliente:
        - Adicionar itens ao carrinho.
        - Remover itens do carrinho.
        - Limpar o carrinho.
        - Finalizar o pedido, enviando-o para a fila de espera.

    Funcionário:
        - Visualizar pedidos em diferentes estágios (em espera, em preparo, finalizados).
        - Atualizar o status dos pedidos (iniciar preparo, finalizar pedido).

## Instruções de Execução:

    - Clone o repositório ou baixe os arquivos do projeto.
    - Certifique-se de que o arquivo Cardapio.txt está no diretório raiz do projeto.
    - Compile e execute o arquivo App.java:
        - Abra o projeto na sua IDE, localize o arquivo App.java e execute-o.

## Instruções de Teste:

    Teste 1: Adicionar Itens ao Carrinho.
        - Execute o programa.
        - Na tela "Pedidos - Área do Cliente", clique no botão "+" ao lado de um item para adicioná-lo ao carrinho.
        - Verifique se o item aparece no campo "Carrinho" e se o valor total é atualizado.

    Teste 2: Remover Itens do Carrinho.
        - Adicione alguns itens ao carrinho.
        - Clique no botão "-" ao lado de um item para removê-lo.
        - Verifique se o item é removido do carrinho e se o valor total é atualizado.

    Teste 3: Limpar o Carrinho
        - Adicione alguns itens ao carrinho.
        - Clique no botão "Limpar Pedido".
        - Verifique se todos os itens são removidos e a mensagem "Pedido limpo com sucesso!" é exibida.

    Teste 4: Finalizar o Pedido
        - Adicione alguns itens ao carrinho.
        - Clique no botão "Concluir Pedido".
        - Verifique se o pedido aparece na tela "Gerenciamento de Pedidos" na seção "EM AGUARDO".
        - Verifique se o carrinho é reiniciado para um novo pedido.

    Teste 5: Atualizar Status do Pedido (Funcionário)
        - Finalize um pedido como cliente.
        - Na tela "Gerenciamento de Pedidos", clique no botão "Iniciar Preparo" para mover o pedido para "EM PREPARO".
        - Clique no botão "Finalizar Pedido" para mover o pedido para "FINALIZADOS".
        - Verifique se o pedido é movido corretamente entre as seções.

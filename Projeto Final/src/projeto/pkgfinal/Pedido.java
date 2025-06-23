package projeto.pkgfinal;

public class Pedido {
    
    
    Cardapio cardapio = new Cardapio("Cardapio.txt");
    int idPedido;
    String status;
    Item cabeca;
    Item cauda;
    int tamanho;

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        this.tamanho = 0;
    }

    public void adicionarNoCarrinho(int i) {
        Item novo = cardapio.getItem(i);
        if (this.getCabeca() == null)
            this.setCabeca(novo);
        else {
            this.getCauda().setProximo(novo);
        }
        novo.setAnterior(this.getCauda());
        this.setCauda(novo);
        this.setTamanho(this.getTamanho() + 1);
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

     public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Item getCabeca() {
        return cabeca;
    }

    public void setCabeca(Item cabeca) {
        this.cabeca = cabeca;
    }

    public Item getCauda() {
        return cauda;
    }

    public void setCauda(Item cauda) {
        this.cauda = cauda;
    }

    public void tirarDoCarrinho(int i) {
        Item itemAux = this.getCabeca();
        Item itemAnterior = null;

        // Varredura para descobrir qual nodo deve ser excluído
        while (itemAux != null && itemAux.getId() != i) {
            itemAnterior = itemAux;
            itemAux = itemAux.getProximo();
        }

        // Caso o nodo a ser excluído seja o primeiro da lista
        if (this.getCabeca() != null) {
            if (itemAnterior == null) {
                this.setCabeca(itemAux.getProximo());
            } else if (itemAux != null) {
                itemAnterior.setProximo(itemAux.getProximo());
            }
        }
    }
    
    public void limparPedido() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
        
    }

    public Pedido finalizar() {        
        return new Pedido(this.idPedido + 1);
    }

    public Item getItem(int i) {
        Item itemAux = this.getCabeca();
        while (itemAux != null && itemAux.getId() != i + 1)
            itemAux = itemAux.getProximo();
        return itemAux;
    }
}

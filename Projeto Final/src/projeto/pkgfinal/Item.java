package projeto.pkgfinal;

public class Item {
    int id;
    String nome;
    Double preco;
    Item anterior;
    Item proximo;
    
    public Item getAnterior() {
        return anterior;
    }

    public void setAnterior(Item anterior) {
        this.anterior = anterior;
    }

    public Item getProximo() {
        return proximo;
    }

    public void setProximo(Item proximo) {
        this.proximo = proximo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Item(int id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.proximo = null;
        this.anterior = null;
    }

    @Override
    public String toString() {
        String item = String.format("O item %s de id %d custa %.2f", this.getNome(),this.getId(),this.getPreco());
        return item;
    }
    
}

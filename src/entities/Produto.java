package entities;

public class Produto {

    private  Integer id;
    private  String nome;
    private  Double preco;
    private  Integer quantidade;

    public Produto(Integer id, String nome, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public Produto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getQuantidade() {
        return quantidade;
    }
    public  void adicionarEstoque(int quantidade){
        this.quantidade += quantidade;

    }
    public void removerEstoque(int quantidade){

        if (quantidade <= this.quantidade){
            this.quantidade -= quantidade;
        }
        else {
            System.out.println("Quantidade insuficiente no estoque! ");
        }
        }

        public void atualizarPreco(double novoPreco){
            this.preco = novoPreco;

        }

    @Override
    public String toString() {
        return "Produto" +
                "id=" + id +
                ", nome=" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade;
    }
}




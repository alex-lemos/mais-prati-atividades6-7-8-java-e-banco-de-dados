package model;

public abstract class Usuario {

    // Atributos
    private String nome;
    private int quantidadeEmprestada = 0;

    // Associações

    // Métodos construtores
    public Usuario(String nome) {
        this.nome = nome;
    }

    // Métodos acessores
    public String getNome() {
        return this.nome;
    }
    public int getQuantidadeEmprestada() {
        return this.quantidadeEmprestada;
    }

    public void incrementarEmprestimo() { quantidadeEmprestada++; }
    public void decrementarEmprestimo() { quantidadeEmprestada--; }

    public abstract int getLimiteItens();

    // toString

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", quantidadeEmprestada=" + quantidadeEmprestada +
                '}';
    }
}

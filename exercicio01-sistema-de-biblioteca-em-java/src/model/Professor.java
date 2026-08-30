package model;

public class Professor extends Usuario {

    // Atributos
    private int limiteItens = 5;

    // Associações

    // Métodos construtores
    public Professor(String nome) {
        super(nome);
    }

    // Métodos acessores
    @Override
    public int getLimiteItens() {
        return this.limiteItens;
    }

    // toString

}

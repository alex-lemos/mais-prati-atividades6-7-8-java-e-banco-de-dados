package model;

public class Aluno extends Usuario{

    // Atributos
    private int limiteItens = 3;

    // Associações

    // Métodos construtores
    public Aluno(String nome)  {
        super(nome);
    }

    // Métodos acessores
    @Override
    public int getLimiteItens() {
        return this.limiteItens;
    }

    // toString

}

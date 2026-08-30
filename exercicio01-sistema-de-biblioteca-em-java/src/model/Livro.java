package model;

public class Livro extends ItemBiblioteca {

    // Atributos
    private final int prazo = 14;
    private final double multaPorDia = 0.50;

    // Associações

    // Métodos construtores
    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    // Métodos acessores
    @Override
    public int getPrazo() {
        return this.prazo;
    }

    @Override
    public double getMultaPorDia() {
        return this.multaPorDia;
    }

    // toString

}

package model;

public class Revista extends ItemBiblioteca {

    // Atributos
    private final int prazo = 7;
    private final double multaPorDia = 1.00;

    // Associações

    // Métodos construtores
    public Revista(String codigo, String titulo) {
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

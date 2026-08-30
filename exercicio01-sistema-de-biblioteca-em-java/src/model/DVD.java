package model;

public class DVD  extends ItemBiblioteca {

    // Atributos
    private final int prazo = 2;
    private final double multaPorDia = 2.00;

    // Associações

    // Métodos construtores
    public DVD(String codigo, String titulo) {
        super(codigo, titulo);
    }

    // Métodos Acessores
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

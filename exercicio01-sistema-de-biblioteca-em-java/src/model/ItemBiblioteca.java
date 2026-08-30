package model;

public abstract class ItemBiblioteca {

    // Atributos
    private String codigo;
    private String titulo;
    private boolean disponivel = true;
    private Usuario emprestadoPara;

    // Associações

    // Métodos construtores
    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    // Métodos acessores
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    public Usuario getEmprestadoPara() { return emprestadoPara; }

    protected void emprestarPara(Usuario usuario) {
        this.disponivel = false;
        this.emprestadoPara = usuario;
    }

    protected void devolver() {
        this.disponivel = true;
        this.emprestadoPara = null;
    }

    public abstract int getPrazo();
    public abstract double getMultaPorDia();

    // toString
    @Override
    public String toString() {
        return "ItemBiblioteca{" +
                "\ncodigo='" + codigo + '\'' +
                ", \ntitulo='" + titulo + '\'' +
                ", \ndisponivel=" + disponivel +
                ", \nemprestadoPara=" + emprestadoPara +
                "\n}";
    }
}

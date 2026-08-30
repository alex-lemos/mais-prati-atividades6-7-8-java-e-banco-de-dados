package model;

public class Biblioteca {

    // Atributos
    private ItemBiblioteca[] itens;
    private Usuario[] usuarios;

    // Associações

    // Métodos construtores
    public Biblioteca(ItemBiblioteca[] itens, Usuario[] usuarios) {
        this.itens = itens;
        this.usuarios = usuarios;
    }

    // Métodos acessores
    public boolean emprestar(ItemBiblioteca item, Usuario usuario) {
        if (!item.isDisponivel()) return false;
        if (usuario.getQuantidadeEmprestada() >= usuario.getLimiteItens()) return false;

        item.emprestarPara(usuario);
        usuario.incrementarEmprestimo();
        return true;
    }

    public double devolver(ItemBiblioteca item, int diasEmprestado) {
        Usuario usuario = item.getEmprestadoPara(); // quem pegou o item
        item.devolver(); // marca como disponível e limpa vínculo
        usuario.decrementarEmprestimo();

        // cálculo da multa
        int prazo = item.getPrazo();
        int diasAtraso = diasEmprestado - prazo;

        if (diasAtraso > 0) {
            return diasAtraso * item.getMultaPorDia();
        }
        return 0;
    }

    public void listarAcervo() {
        for (int i = 0; i < itens.length; i++) {
            ItemBiblioteca item = itens[i];
            System.out.println("Posição " + i + ": "
                    + item.getCodigo() + " - "
                    + item.getTitulo() + " - Disponível: "
                    + item.isDisponivel());
        }
    }

    public void listarUsuarios() {
        for (int i = 0; i < usuarios.length; i++) {
            Usuario usuario = usuarios[i];
            System.out.println("Posição " + i + ": "
                    + usuario.getNome() + " - Itens emprestados: "
                    + usuario.getQuantidadeEmprestada());
        }
    }

    // toString

}

import model.*;

public class Main {
    public static void main(String[] args) {
        ItemBiblioteca[] itens = {
                new Livro("L001", "Java Básico"),          // 0
                new Revista("R001", "Revista Ciência Hoje"), // 1
                new DVD("D001", "Matrix DVD"),             // 2
                new Livro("L002", "Banco de Dados Avançado"), // 3
                new Livro("L003", "Estruturas de Dados"),  // 4
                new Revista("R002", "Revista Tech"),       // 5
                new DVD("D002", "Senhor dos Anéis DVD")    // 6
        };

        Usuario[] usuarios = {
                new Aluno("Carlos"), // 0
                new Professor("Maria") // 1
        };

        Biblioteca biblioteca = new Biblioteca(itens, usuarios);

        System.out.println("--------------------");
        System.out.println("Itens Biblioteca:");
        biblioteca.listarAcervo();

        System.out.println("\nUsuarios Biblioteca:");
        biblioteca.listarUsuarios();

        System.out.println("\nEmpréstimo livro Java Básico para Maria:");
        System.out.println(biblioteca.emprestar(itens[0], usuarios[1]));
        System.out.println(itens[0].toString());

        System.out.println("\nItens Biblioteca:");
        biblioteca.listarAcervo();

        System.out.println("\nCarlos pegando 1 a 4 itens:");
        System.out.println(biblioteca.emprestar(itens[1], usuarios[0]));
        System.out.println(biblioteca.emprestar(itens[2], usuarios[0]));
        System.out.println(biblioteca.emprestar(itens[3], usuarios[0]));
        System.out.println(biblioteca.emprestar(itens[4], usuarios[0])); // falha (limite 3)
        System.out.println(usuarios[0].toString());

        System.out.println("\nItens Biblioteca:");
        biblioteca.listarAcervo();

        System.out.println("\nCarlos devolvendo itens 1 e 3 em dia:");
        System.out.println("Multa calculada: R$ " + biblioteca.devolver(itens[1], 1));
        System.out.println("Multa calculada: R$ " + biblioteca.devolver(itens[3], 2));        ;
        System.out.println(usuarios[0].toString());

        System.out.println("\nItens Biblioteca:");
        biblioteca.listarAcervo();

        System.out.println(itens[0].toString());
        System.out.println(itens[2].toString());

        System.out.println("\nCarlos Tentanto pegar item 0 já emprestado:");
        System.out.println(biblioteca.emprestar(itens[0], usuarios[0]));
        System.out.println(itens[0].toString());

        System.out.println("\nCarlos devolvendo item 2 com 1 dia de atraso:");
        System.out.println("Multa calculada: R$ " + biblioteca.devolver(itens[2], 3));

        System.out.println("\nMaria devolvendo item 0 com 1 dia de atraso:");
        System.out.println("Multa calculada: R$ " + biblioteca.devolver(itens[0], 15));

        System.out.println("--------------------");
        System.out.println("Itens Biblioteca:");
        biblioteca.listarAcervo();

        System.out.println("\nUsuarios Biblioteca:");
        biblioteca.listarUsuarios();
    }
}
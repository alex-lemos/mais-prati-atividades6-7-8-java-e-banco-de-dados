# Lista de Exercícios - Sistema de Biblioteca (Java + PostgreSQL)

Formação Desenvolvedor Full Stack Júnior

## Exercício 1 — Sistema de Biblioteca em Java
Uma biblioteca de bairro quer controlar seu acervo — livros e revistas — emprestado a alunos e professores.  
- Livro: 14 dias de prazo, multa de R$ 0,50/dia.  
- Revista: 7 dias de prazo, multa de R$ 1,00/dia.  
- Aluno: até 3 itens simultâneos.  
- Professor: até 5 itens simultâneos.  

### O que fazer
1. Classe abstrata `ItemBiblioteca` (código, título, disponível) com prazo e multa como métodos abstratos, implementados em `Livro` e `Revista`.  
2. Classe abstrata `Usuario` (nome, quantidadeEmprestada) com limite de itens como método abstrato, implementado em `Aluno` e `Professor`.  
3. Classe `Biblioteca` com `emprestar()`, `devolver()` e `listarAcervo()`, usando arrays de tamanho fixo.  
4. Classe `Main` com cenário de teste: cadastro, um empréstimo bem-sucedido e um recusado por limite atingido.  

### Dicas
- Prazo e multa variam por tipo → métodos abstratos.  
- Não criar `setDisponivel()` público → disponibilidade muda apenas em `emprestar()` e `devolver()`.  
- `listarAcervo()` deve percorrer `ItemBiblioteca[]` em um único laço, sem `if` de tipo.  
- Testar criando uma categoria nova (ex.: `DVD`) sem alterar métodos já escritos.  

---

## Exercício 2 — Modelagem do Banco de Dados (PostgreSQL)
Modelar o mesmo cenário em tabelas relacionais, sem herança: tipo definido por coluna.

### Tabelas
- **item**: id, código, título, tipo, autor, edição, disponível.  
- **usuario**: id, nome, tipo, limite_itens.  
- **emprestimo**: id, item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa.  

### Regras
- Usar `GENERATED ALWAYS AS IDENTITY` para chaves primárias.  
- Usar `CHECK (tipo IN (...))` para restringir valores possíveis.  
- `item_id` e `usuario_id` são chaves estrangeiras.  
- `data_devolucao` pode ser nula (enquanto não devolvido).  
- Ordem dos `CREATE TABLE` importa: primeiro `item` e `usuario`, depois `emprestimo`.  

### Dados de teste
- Pelo menos 4 itens.  
- 2 usuários.  
- 2 empréstimos (um em aberto e um devolvido).  

---

## Exercício 3 — Consultas SQL
Com as tabelas e dados prontos, criar 4 consultas:

1. Listar todo o acervo (código, título, tipo, disponibilidade).  
2. Listar empréstimos em aberto (nome do usuário e título do item).  
3. Calcular o total de multas acumuladas por usuário.  
4. Listar itens que nunca foram emprestados.  

### Dicas
- Consultas 1 e 2 precisam de `JOIN`.  
- Empréstimo em aberto: `data_devolucao IS NULL`.  
- Consulta 3: usar `GROUP BY` usuário + `SUM(valor_multa)`.  
- Consulta 4: usar `LEFT JOIN` entre item e emprestimo e testar `IS NULL`.  

---

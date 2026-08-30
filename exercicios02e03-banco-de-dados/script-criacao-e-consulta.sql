/* EXERCÍCIO 2 — Modelagem do Banco de Dados */

-- Criação do banco:
CREATE TABLE item (
    id INT GENERATED ALWAYS AS IDENTITY,
    codigo VARCHAR(20) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    autor VARCHAR(100),
    edicao VARCHAR(20),
    disponivel BOOLEAN DEFAULT TRUE,
    CONSTRAINT pk_item PRIMARY KEY (id),
    CONSTRAINT uq_item_codigo UNIQUE (codigo),
    CONSTRAINT ck_item_tipo CHECK (tipo IN ('livro', 'revista'))
);

CREATE TABLE usuario (
    id INT GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    limite_itens INT NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id),
    CONSTRAINT ck_usuario_tipo CHECK (tipo IN ('aluno', 'professor'))
);

CREATE TABLE emprestimo (
    id INT GENERATED ALWAYS AS IDENTITY,
    item_id INT NOT NULL,
    usuario_id INT NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) DEFAULT 0,
    CONSTRAINT pk_emprestimo PRIMARY KEY (id),
    CONSTRAINT fk_emprestimo_item FOREIGN KEY (item_id) REFERENCES item(id),
    CONSTRAINT fk_emprestimo_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);


-- Dados de teste:
INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES 
('L001', 'Java Básico', 'livro', 'Autor A', '1ª', TRUE),
('L002', 'Banco de Dados', 'livro', 'Autor B', '2ª', TRUE),
('R001', 'Revista Ciência Hoje', 'revista', 'Editor X', '45', TRUE),
('R002', 'Revista Tech', 'revista', 'Editor Y', '12', TRUE);

INSERT INTO usuario (nome, tipo, limite_itens)
VALUES 
('Carlos', 'aluno', 3),
('Maria', 'professor', 5);

-- Já devolvido
INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES 
(2, 2, '2026-08-01', '2026-08-15', '2026-08-16', 0.50);

-- Em aberto
INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista)
VALUES 
(1, 1, '2026-08-20', '2026-09-03');

UPDATE item
	SET disponivel = false
	WHERE id = 1;

-----------------------------------------------------------------
/* EXERCÍCIO 3 — Consula SQL */

-- 1. listar todo o acervo, com código, título, tipo e disponibilidade. 
SELECT codigo, titulo, tipo, disponivel
	FROM item;

-- 2. listar os empréstimos em aberto, com o nome do usuário e o título do item. 
SELECT u.nome, i.titulo
	FROM emprestimo e JOIN usuario u ON e.usuario_id = u.id
		JOIN item i ON e.item_id = i.id
	WHERE e.data_devolucao IS NULL;

-- 3. calcular o total de multas acumuladas por usuário. 
SELECT u.nome, SUM(e.valor_multa) AS total_multas
	FROM usuario u JOIN emprestimo e ON u.id = e.usuario_id
 	GROUP BY u.nome;

-- 4. listar os itens que nunca foram emprestados. 
SELECT i.codigo, i.titulo, i.tipo
	FROM item i LEFT JOIN emprestimo e ON i.id = e.item_id
	WHERE e.id IS NULL;
	
-----------------------------------------------------------------

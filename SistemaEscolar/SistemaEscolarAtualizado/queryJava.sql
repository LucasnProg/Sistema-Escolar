create database boletim_bm;

use boletim_bm;

create table usuario(
	cpf varchar(20) primary key,
    nome varchar(250) not null,
    senha varchar(250) not null
);

create table aluno(
	cpf varchar(20),
    matricula varchar(250) not null,
    cra float,
    primary key(cpf),
    foreign key (cpf) references usuario(cpf)
    
);

create table professor(
	cpf VARCHAR(20),
    matricula VARCHAR(250) NOT NULL,
    PRIMARY KEY (cpf),
    FOREIGN KEY (cpf) REFERENCES usuario(cpf)
);

create table coordenador(
	cpf varchar(20),
	primary key(cpf),
    foreign key (cpf) references usuario(cpf)
);

-- Criação da tabela disciplina
CREATE TABLE disciplina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(250) NOT NULL,
    professor_cpf VARCHAR(20),
    FOREIGN KEY (professor_cpf) REFERENCES professor(cpf)
);

-- Criação da tabela boletim
CREATE TABLE boletim (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_cpf VARCHAR(20),
    disciplina_id INT,
    
    FOREIGN KEY (aluno_cpf) REFERENCES aluno(cpf),
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
);

-- Criação da tabela nota
CREATE TABLE nota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    boletim_id INT,
    valor DECIMAL(5, 2) NOT NULL,
    FOREIGN KEY (boletim_id) REFERENCES boletim(id)
);

-- Tabela professor_disciplina
CREATE TABLE professor_disciplina (
    professor_cpf VARCHAR(20) NOT NULL,
    disciplina_id INT NOT NULL,
    PRIMARY KEY (professor_cpf, disciplina_id),
    FOREIGN KEY (professor_cpf) REFERENCES professor(cpf),
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
);

-- Tabela aluno_disciplina
CREATE TABLE aluno_disciplina (
    aluno_cpf VARCHAR(20) NOT NULL,
    disciplina_id INT NOT NULL,
    PRIMARY KEY (aluno_cpf, disciplina_id),
    FOREIGN KEY (aluno_cpf) REFERENCES aluno(cpf),
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
);


select * from usuario;
select * from aluno;
	
-- Preenchendo a tabela usuario
INSERT INTO usuario (cpf, nome, senha) VALUES
('11122233344', 'Ana Costa', 'senha789'),
('44455566677', 'Pedro Lima', 'senha101'),
('88899900011', 'Lucas Pereira', 'senha202'),
('12312312312', 'Mariana Santos', 'senha303'),
('32132132132', 'Juliana Alves', 'senha404');

-- Preenchendo a tabela aluno
INSERT INTO aluno (cpf, matricula, cra) VALUES
('11122233344', 'A67890', 7.8),
('12312312312', 'A23456', 9.2);


-- Preenchendo a tabela professor
INSERT INTO professor (cpf, matricula) VALUES
('44455566677', 'P54321'),
('88899900011', 'P65432');

-- Preenchendo a tabela coordenador
INSERT INTO coordenador (cpf) VALUES
('32132132132');

-- Preenchendo a tabela disciplina
INSERT INTO disciplina (id, nome, professor_cpf) VALUES
(3, 'Física', '44455566677'),
(4, 'Química', '88899900011'),
(5, 'Biologia', '44455566677');

-- Preenchendo a tabela boletim
INSERT INTO boletim (id, aluno_cpf, disciplina_id) VALUES
(3, '11122233344', 3),
(4, '11122233344', 4),
(5, '12312312312', 1),
(6, '12312312312', 2),
(7, '12312312312', 5);

-- Preenchendo a tabela nota
INSERT INTO nota (id, boletim_id, valor) VALUES
(3, 3, 6.5),
(4, 4, 8.0),
(5, 5, 9.5),
(6, 6, 9.0),
(7, 7, 8.8);

-- Preenchendo a tabela professor_disciplina
INSERT INTO professor_disciplina (professor_cpf, disciplina_id) VALUES
('98765432100', 1),  -- João Silva ministra Matemática
('98765432100', 2),  -- João Silva ministra História
('44455566677', 3),  -- Pedro Lima ministra Física
('88899900011', 4),  -- Lucas Pereira ministra Química
('44455566677', 5);  -- Pedro Lima ministra Biologia

-- Preenchendo a tabela aluno_disciplina
INSERT INTO aluno_disciplina (aluno_cpf, disciplina_id) VALUES
('12345678901', 1),  -- João Silva matriculado em Matemática
('12345678901', 2),  -- João Silva matriculado em História
('11122233344', 3),  -- Ana Costa matriculada em Física
('11122233344', 4),  -- Ana Costa matriculada em Química
('12312312312', 1),  -- Mariana Santos matriculada em Matemática
('12312312312', 2),  -- Mariana Santos matriculada em História
('12312312312', 5);  -- Mariana Santos matriculada em Biologia


create database sistema_agendamento;

CREATE TABLE estagiario (
    codigo_estagiario INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    matricula INTEGER(8) NOT NULL,
    disciplinas_cursadas TEXT NOT NULL,
    ativo BOOLEAN,
    UNIQUE (matricula)
);

CREATE TABLE usuario (
    codigo_usuario INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    codigo_paciente INTEGER NOT NULL,
    codigo_consulta INTEGER NOT NULL,
    nome_usuario VARCHAR(15) NOT NULL,
    senha INTEGER NOT NULL,
    ativo BOOLEAN,
    UNIQUE (nome_usuario)
);

CREATE TABLE professor (
    codigo_professor INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    numero_identificacao INTEGER(8) NOT NULL,
    disciplinas TEXT NOT NULL,
    estagiarios_supervisionados TEXT NOT NULL,
    ativo BOOLEAN,
    UNIQUE (numero_identificacao)
);

CREATE TABLE consulta (
    codigo_consulta INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    codigo_paciente INTEGER NOT NULL,
    paciente VARCHAR(100) NOT NULL,
    data_consulta DATE NOT NULL,
    horario TIME NOT NULL,
    ativo BOOLEAN,
    UNIQUE (paciente)
);

CREATE TABLE paciente (
    codigo_paciente INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    data_nascimento INTEGER(8) NOT NULL,
    genero CHARACTER(1) NOT NULL,
    estado_civil VARCHAR(10) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    cep INTEGER(8) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    ativo BOOLEAN,
    UNIQUE (email)
);

CREATE TABLE cidade (
    codigo_cidade INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    codigo_estado INTEGER NOT NULL,
    nome VARCHAR(150) NOT NULL,
    ativo BOOLEAN
);

CREATE TABLE estado (
    codigo_estado INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    sigla CHARACTER(2) NOT NULL,
    ativo BOOLEAN
);
 
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_3
    FOREIGN KEY (codigo_paciente???, codigo_consulta???)
    REFERENCES ??? (???);
 
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_4
    FOREIGN KEY (senha, ???)
    REFERENCES consulta (codigo_consulta, ???);
 
ALTER TABLE consulta ADD CONSTRAINT FK_consulta_3
    FOREIGN KEY (codigo_paciente???)
    REFERENCES ??? (???);
 
ALTER TABLE cidade ADD CONSTRAINT FK_cidade_3
    FOREIGN KEY (codigo_estado???)
    REFERENCES ??? (???);


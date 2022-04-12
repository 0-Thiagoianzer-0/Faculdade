package model.bean;

import java.util.List;

public class Pessoa {

    private int cod_pessoa;
    private String nome,data_nascimento,sexo,altura,peso,data_cadastro,ativ_fisica,ativ_frequencia,bebidas_alcool,bebidas_frequencia,alimentacao,alimentacao_tipo,fumante,doenca,doenca_nome,medicamentos,jornada_trabalho,forma_trabalho,ativ_diaria,ativo;

    public int getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(int cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getAtiv_fisica() {
        return ativ_fisica;
    }

    public void setAtiv_fisica(String ativ_fisica) {
        this.ativ_fisica = ativ_fisica;
    }

    public String getAtiv_frequencia() {
        return ativ_frequencia;
    }

    public void setAtiv_frequencia(String ativ_frequencia) {
        this.ativ_frequencia = ativ_frequencia;
    }

    public String getBebidas_alcool() {
        return bebidas_alcool;
    }

    public void setBebidas_alcool(String bebidas_alcool) {
        this.bebidas_alcool = bebidas_alcool;
    }

    public String getBebidas_frequencia() {
        return bebidas_frequencia;
    }

    public void setBebidas_frequencia(String bebidas_frequencia) {
        this.bebidas_frequencia = bebidas_frequencia;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getAlimentacao_tipo() {
        return alimentacao_tipo;
    }

    public void setAlimentacao_tipo(String alimentacao_tipo) {
        this.alimentacao_tipo = alimentacao_tipo;
    }

    public String getFumante() {
        return fumante;
    }

    public void setFumante(String fumante) {
        this.fumante = fumante;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getDoenca_nome() {
        return doenca_nome;
    }

    public void setDoenca_nome(String doenca_nome) {
        this.doenca_nome = doenca_nome;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getJornada_trabalho() {
        return jornada_trabalho;
    }

    public void setJornada_trabalho(String jornada_trabalho) {
        this.jornada_trabalho = jornada_trabalho;
    }

    public String getForma_trabalho() {
        return forma_trabalho;
    }

    public void setForma_trabalho(String forma_trabalho) {
        this.forma_trabalho = forma_trabalho;
    }

    public String getAtiv_diaria() {
        return ativ_diaria;
    }

    public void setAtiv_diaria(String ativ_diaria) {
        this.ativ_diaria = ativ_diaria;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    public void add(List<Pessoa> listapessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
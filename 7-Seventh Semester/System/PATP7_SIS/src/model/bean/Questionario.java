package model.bean;

import java.util.List;

public class Questionario {

    private int cod_questionario, questionario_cod_pessoa;
    private String data_medicao,peso,status,ocorrencia,comentario,ativo;

    public int getCod_questionario() {
        return cod_questionario;
    }

    public void setCod_questionario(int cod_questionario) {
        this.cod_questionario = cod_questionario;
    }

    public int getQuestionario_cod_pessoa() {
        return questionario_cod_pessoa;
    }

    public void setQuestionario_cod_pessoa(int questionario_cod_pessoa) {
        this.questionario_cod_pessoa = questionario_cod_pessoa;
    }

    public String getData_medicao() {
        return data_medicao;
    }

    public void setData_medicao(String data_medicao) {
        this.data_medicao = data_medicao;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public void add(List<Questionario> listaquestionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

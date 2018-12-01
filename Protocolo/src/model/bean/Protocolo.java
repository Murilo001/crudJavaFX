/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Murilo
 */
public class Protocolo {
    private long id;
    private long numeroProtocolo;
    private String pessoaNome;
    private String referencia;
    private String anotacoes;
    private long tipoProtocolo;;
    private long seloId;
    private Date dataCadastro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(long numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public long getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(long tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public long getSeloId() {
        return seloId;
    }

    public void setSeloId(long seloId) {
        this.seloId = seloId;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
}

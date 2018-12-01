/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Murilo
 */
public class ProtocoloTable {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nomePessoa;
    private final SimpleStringProperty anotacoes;
 
    public ProtocoloTable(String pId, String pNomePessoa, String pAnotacoes) {
        this.id = new SimpleStringProperty(pId);
        this.nomePessoa = new SimpleStringProperty(pNomePessoa);
        this.anotacoes = new SimpleStringProperty(pAnotacoes);
    }
 
    public String getId() {
        return id.get();
    }
    public void setId(String pId) {
        id.set(pId);
    }
        
    public String getNomePessoa() {
        return nomePessoa.get();
    }
    public void setNomePessoa(String pNomePessoa) {
        nomePessoa.set(pNomePessoa);
    }
    
    public String getAnotacoes() {
        return anotacoes.get();
    }
    public void setAnotacoes(String fAnotacoes) {
        anotacoes.set(fAnotacoes);
    }
}

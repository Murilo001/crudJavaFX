/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Protocolo;

/**
 *
 * @author Murilo
 */
public class ProtocoloDAO {
    
    public void create(Protocolo p) {
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO protocolo (tipo_protocolo, pessoa_nome, numero_protocolo, referencia, anotacoes, data_cadastro)VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, (int)p.getNumeroProtocolo());
            stmt.setString(2, p.getPessoaNome());
            stmt.setInt(3, (int)p.getNumeroProtocolo());
            stmt.setString(4, p.getReferencia());
            stmt.setString(5, p.getAnotacoes());
            stmt.setDate(6, p.getDataCadastro());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    
    public List<Protocolo> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Protocolo> protocolos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM protocolo");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Protocolo protocolo = new Protocolo();
                protocolo.setId(rs.getInt("id"));
                protocolo.setTipoProtocolo(rs.getInt("tipo_protocolo"));
                protocolo.setPessoaNome(rs.getString("pessoa_nome"));
                protocolo.setNumeroProtocolo(rs.getInt("numero_protocolo"));
                protocolo.setReferencia(rs.getString("referencia"));
                protocolo.setAnotacoes(rs.getString("anotacoes"));
                protocolo.setDataCadastro(rs.getDate("data_cadastro"));
                protocolo.setSeloId(rs.getInt("selo_id"));
                
                protocolos.add(protocolo);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
                
        return protocolos;
    }
    
    
    
}

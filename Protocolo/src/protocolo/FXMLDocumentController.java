/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import protocolo.model.TipoProtocolo;

/**
 *
 * @author Murilo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btSalvar;

    @FXML
    private Label label;

    @FXML
    private ComboBox<TipoProtocolo> tipoProtocolo;

    @FXML
    private DatePicker dataProtocolo;

    @FXML
    private TextField nomePessoa;

    @FXML
    private TextField referencia;

    @FXML
    private Button btBusca;

    @FXML
    private Label label1;

    @FXML
    private Label label11;

    @FXML
    private Label label12;

    @FXML
    private Label label121;

    private List<TipoProtocolo> tiposProtocolo = new ArrayList();
    
    private ObservableList<TipoProtocolo> obsTipoProtocolos;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTipoProtocolo();
    }    
    
    public void carregarTipoProtocolo() {
        TipoProtocolo protocolo1 = new TipoProtocolo(1, "Registro de Imóveis");
        TipoProtocolo protocolo2 = new TipoProtocolo(2, "Título e Documentos");
        TipoProtocolo protocolo3 = new TipoProtocolo(3, "Pessoa Jurídica");
        
        tiposProtocolo.add(protocolo1);
        tiposProtocolo.add(protocolo2);
        tiposProtocolo.add(protocolo3);
        
        obsTipoProtocolos = FXCollections.observableArrayList(tiposProtocolo);
        tipoProtocolo.setItems(obsTipoProtocolos);
    }
    
}

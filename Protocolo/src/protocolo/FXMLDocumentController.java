/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import protocolo.model.TipoProtocolo;
import model.bean.Protocolo;
import model.bean.ProtocoloTable;
import model.dao.ProtocoloDAO;

/**
 *
 * @author Murilo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView<ProtocoloTable> tabelaResultado;
    
    @FXML 
    private TableColumn<ProtocoloTable, String> protocoloId;
    
    @FXML 
    private TableColumn<ProtocoloTable, String> protocoloNomePessoa;
    
    @FXML 
    private TableColumn<ProtocoloTable, String> protocoloAnotacoes;
    
    @FXML
    private Pane paneInvisivel;
    
    @FXML
    private Button btSalvar;

    @FXML
    private ComboBox<TipoProtocolo> tipoProtocolo;

    @FXML
    private ComboBox<TipoProtocolo> tipoProtocoloCadastro;
    
    @FXML
    private DatePicker dataProtocolo;

    @FXML
    private TextField nomePessoa;
    
    @FXML
    private TextField nomePessoaCadastro;
    
    @FXML
    private TextField referencia;
    @FXML
    private TextField referenciaCadastro;
    
    @FXML
    private TextField anotacoesCadastro;

    @FXML
    private Button btBusca;
    
    private ObservableList<TipoProtocolo> obsTipoProtocolos;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTipoProtocolo(tipoProtocolo);
        carregarTipoProtocolo(tipoProtocoloCadastro);
        definirAcaoComboBoxCadastro(tipoProtocoloCadastro);
    }    
    
        
        
    @FXML
    private void acaoBuscar(ActionEvent event) {
        protocoloId.setCellValueFactory(new PropertyValueFactory<ProtocoloTable, String>("id"));
        protocoloNomePessoa.setCellValueFactory(new PropertyValueFactory<ProtocoloTable, String>("nomePessoa"));
        protocoloAnotacoes.setCellValueFactory(new PropertyValueFactory<ProtocoloTable, String>("anotacoes"));
        tabelaResultado.setVisible(true);
        tabelaResultado.getItems().setAll(carregarDadosTabela());
    }
    
    @FXML
    private void acaoSalvar(ActionEvent event) {
        java.sql.Date ourJavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Protocolo novoProtocolo = new Protocolo();
        ProtocoloDAO dao = new ProtocoloDAO();
        novoProtocolo.setTipoProtocolo(1);
        novoProtocolo.setPessoaNome(nomePessoaCadastro.getText());
        novoProtocolo.setNumeroProtocolo(13);
        novoProtocolo.setReferencia(referenciaCadastro.getText());
        novoProtocolo.setAnotacoes(anotacoesCadastro.getText());
        novoProtocolo.setDataCadastro(ourJavaDateObject);
        dao.create(novoProtocolo);
    }
    
    public void definirAcaoComboBoxCadastro(ComboBox combo) {
        combo.setOnAction(event -> paneInvisivel.setVisible(true));
    }
    
    public void carregarTipoProtocolo(ComboBox tipoProtocoloParametro) {
        List<TipoProtocolo> tiposProtocolo = new ArrayList();
        TipoProtocolo protocolo1 = new TipoProtocolo(1, "Registro de Imóveis");
        TipoProtocolo protocolo2 = new TipoProtocolo(2, "Título e Documentos");
        TipoProtocolo protocolo3 = new TipoProtocolo(3, "Pessoa Jurídica");
        
        tiposProtocolo.add(protocolo1);
        tiposProtocolo.add(protocolo2);
        tiposProtocolo.add(protocolo3);
        
        obsTipoProtocolos = FXCollections.observableArrayList(tiposProtocolo);
        tipoProtocoloParametro.setItems(obsTipoProtocolos);
    }
    
    public List<ProtocoloTable> carregarDadosTabela() {
        ProtocoloDAO protocolos = new ProtocoloDAO();
        List<ProtocoloTable> tabelaProtocolos = new ArrayList<>();
        
        for (Protocolo p : protocolos.read())
        {
            ProtocoloTable tabela = new ProtocoloTable(Integer.toString((int) p.getId()), p.getPessoaNome(), p.getAnotacoes());
            tabelaProtocolos.add(tabela);
        }
        return tabelaProtocolos;
    }
    
}

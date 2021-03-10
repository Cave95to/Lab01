package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML
    void doInsert(ActionEvent event) {
    	this.elenco.addParola(this.txtParola.getText());
    	this.txtParola.setText("");
    	String s="";
    	for(String st : this.elenco.getElenco() ) {
    		s =s+st+"\n";
    	}
    	this.txtResult.setText(s);
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.elenco.reset();
    	this.txtResult.setText("");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String s = this.txtResult.getSelectedText();
    	this.elenco.removeParola(s);
    	String str="";
    	for(String st : this.elenco.getElenco() ) {
    		str =str+st+"\n";
    	}
    	this.txtResult.setText(str);

    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }
}

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
    private TextArea txtTempi;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double start = System.nanoTime();
    	
    	this.elenco.addParola(this.txtParola.getText());
    	
    	double stop = System.nanoTime();
    	
    	this.txtParola.setText("");
    	String s="";
    	for(String st : this.elenco.getElenco() ) {
    		s =s+st+"\n";
    	}
    	this.txtResult.setText(s);
    	this.txtTempi.appendText("[INSERT]: " + (stop - start)/1e9 + " seconds\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	double start = System.nanoTime();
    	this.elenco.reset();
    	double stop = System.nanoTime();
    	this.txtResult.setText("");
    	this.txtTempi.appendText("[RESET]: " + (stop - start)/1e9 + " seconds\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String s = this.txtResult.getSelectedText();
    	double start = System.nanoTime();
    	this.elenco.removeParola(s);
    	double stop = System.nanoTime();
    	s ="";
    	for(String st : this.elenco.getElenco() ) {
    		s = s + st + "\n";
    	}
    	this.txtResult.setText(s);
    	this.txtTempi.appendText("[REMOVE]: " + (stop - start)/1e9 + " seconds\n");
    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }
}

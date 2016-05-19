/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.models.Assistente;
import com.mycompany.models.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author freeman
 */
public class DeletarController implements Initializable{
    
    private Assistente assistente;
    
    @FXML
    private TextField idTextField;
    @FXML
    private Button cancelar;
    @FXML
    private Button deletar;

    public Assistente getAssistente() {
        return assistente;
    }

    public void setAssistente(Assistente assistente) {
        this.assistente = assistente;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    private void handleButtonDeletar() {
        Produto p = assistente.pegaProduto(idTextField.getText());
        assistente.removeProduto(p);
        idTextField.setText("");
    }
    
    @FXML
    private void handleButtonCancelar() throws IOException {
        Stage stage;
        Parent root;  
        stage = (Stage) cancelar.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fxml/BuscaView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author freeman
 */
public class BuscaController implements Initializable {

    private Assistente assistente;
    private ObservableList<Produto> dadosDaTabela;

    @FXML
    private Button cadastrar;
    @FXML
    private Button deletar;
    @FXML
    private Button procurar;
    @FXML
    private TextField procurarTxtField;
    @FXML
    private TableView<Produto> tableView;
    @FXML
    private TableColumn<ObservableList<String>, String> idColumn;
    @FXML
    private TableColumn<ObservableList<String>, String> produtoColumn;
    @FXML
    private TableColumn<ObservableList<String>, String> mercadoColumn;
    @FXML
    private TableColumn<ObservableList<String>, String> precoColumn;

    public void setAssistente(Assistente assistente) {
        this.assistente = assistente;
    }

    public Assistente getAssistente() {
        return assistente;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.assistente = new Assistente();
        this.assistente.recuperaProdutos();
        atualizarTabela();
    }
    
    public void atualizarTabela() {
        dadosDaTabela = FXCollections.observableList(assistente.getProdutos());
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        produtoColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        mercadoColumn.setCellValueFactory(new PropertyValueFactory("mercado"));
        precoColumn.setCellValueFactory(new PropertyValueFactory("preco"));
        this.tableView.setItems(dadosDaTabela);
    }

    @FXML
    private void handleButtonCadastrarProduto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CadastrarView.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        CadastrarController cadastrarController = fxmlLoader.<CadastrarController>getController();
        Stage stage = (Stage) cadastrar.getScene().getWindow();
        cadastrarController.setAssistente(assistente);
        Scene scene = new Scene(root);
        stage.setTitle("Ideal Produto");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleButtonDeletarProduto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DeletarView.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        DeletarController deletarController = fxmlLoader.<DeletarController>getController();
        Stage stage = (Stage) cadastrar.getScene().getWindow();
        deletarController.setAssistente(assistente);
        Scene scene = new Scene(root);
        stage.setTitle("Ideal Produto");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleButtonProcurarProduto() {

    }

}

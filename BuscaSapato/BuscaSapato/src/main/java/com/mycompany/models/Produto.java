/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author freeman
 */
@Entity("Produto")
public class Produto {
    
    @Id
    private ObjectId id;
    private String nome;
    private String mercado;
    private String preco;
    
    public Produto() {
    }
    
    public Produto(String nome, String mercado, String preco) {
        this.nome = nome;
        this.mercado = mercado;
        this.preco = preco;
    }

    public Produto(ObjectId id, String nome, String mercado, String preco) {
        this.id = id;
        this.nome = nome;
        this.mercado = mercado;
        this.preco = preco;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    public void mostraProduto() {
        System.out.println("nome: " + this.nome+"\n"
                + "mercado: "+this.mercado+"\n"
                + "preço: "+this.preco+"\n"
                + "---------------------------");
    }
}

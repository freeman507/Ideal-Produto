/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author freeman
 */
public class Assistente {
    
    private ArrayList<Produto> produtos;
    private final Morphia morphia;
    private final Datastore datastore;

    public Assistente() {
        this.produtos = new ArrayList<>();
        this.morphia = new Morphia();
        morphia.mapPackage("com.mycompany.models");
        datastore = morphia.createDatastore(new MongoClient(), "IdealProduto");
        datastore.ensureIndexes();
    }

    public Assistente(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        this.morphia = new Morphia();
        morphia.mapPackage("com.mycompany.models");
        datastore = morphia.createDatastore(new MongoClient(), "IdealProduto");
        datastore.ensureIndexes();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void addProduto(Produto produto) {
        datastore.save(produto);
        this.produtos.add(produto);
    }
    
    public void removeProduto(Produto produto) {
        final Query<Produto> query = datastore.createQuery(Produto.class)
                .filter("_id ==", produto.getId());
        datastore.delete(query);
        this.produtos.remove(produto);
    }
    
    public void recuperaProdutos() {
        List<Produto> list = datastore.createQuery(Produto.class).asList();
        for(Produto produto : list) {
            this.produtos.add(produto);
        }
    }
    
    public Produto pegaProduto(String id) {
        for (Produto produto : produtos) {
            if(produto.getId().toString().equals(id))
                return produto;
        }
        return null;
    }
    
    public void mostrarProdutos() {
        for (Produto produto : produtos) {
            System.out.println("id: "+ produto.getId());
            System.out.println("nome: "+ produto.getNome());
            System.out.println("mercado: "+ produto.getMercado());
            System.out.println("preço: "+ produto.getPreco());
            System.out.println("--------------------------------");
        }
    }
}

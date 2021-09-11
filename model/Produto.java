/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mauri
 */
public class Produto {

    private int idProduto;
    private String nomeProd;
    private float valorProd;
    private int qtdProd;
    private Fornecedor fornecedor;

    public Produto() {
        idProduto = 0;
        nomeProd = new String();
        valorProd = 0;
        qtdProd = 0;
        fornecedor = new Fornecedor();

    }

    public Produto(int idProduto, String nomeProd, float ValorProd, int qtdProd, Fornecedor fornecedor) {
        this.idProduto = idProduto;
        this.nomeProd = nomeProd;
        this.valorProd = ValorProd;
        this.qtdProd = qtdProd;
        this.fornecedor = fornecedor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public float getValorProd() {
        return valorProd;
    }

    public void setValorProd(float valorProd) {
        this.valorProd = valorProd;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return nomeProd;
    }

}

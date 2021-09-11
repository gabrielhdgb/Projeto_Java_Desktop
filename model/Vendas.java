/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class Vendas {

    private int qtdProduto;
    private float valorTotal;
    private Produto produto;
    private Pedido pedido;

    public Vendas() {
        qtdProduto = 0;
        valorTotal = 0;
        produto = new Produto();
        pedido = new Pedido();
    }

    public Vendas(int qtdProduto, float valorTotal, Produto produto, Pedido pedido) {
        this.qtdProduto = qtdProduto;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.pedido = pedido;

    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


}

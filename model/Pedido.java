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
public class Pedido {

    private int idPedido;
    private String data;
    private int status;
    private String formaPagamento;
    private Usuario cliente;

    public Pedido() {
        idPedido = 0;
        data = new String();
        status = 0;
        formaPagamento = new String();
        cliente = new Usuario();

    }

    public Pedido(int idPedido, String data, int status, String formaPagamento, Usuario cliente) {
        this.idPedido = idPedido;
        this.data = data;
        this.status = status;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

       
}

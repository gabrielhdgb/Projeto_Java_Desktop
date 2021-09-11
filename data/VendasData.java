/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fornecedor;
import model.Pedido;
import model.Produto;
import model.Vendas;

/**
 *
 * @author mauri
 */
public class VendasData extends Conexao {

    public VendasData() throws SQLException, ClassNotFoundException {
    }

    public boolean incluir(ArrayList<Vendas> obj) throws Exception {

        for (Vendas v : obj) {

            String sql = "Insert into vendas (idProduto,idPedido,qtdProduto,precoVenda) values (?,?,?,?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, v.getProduto().getIdProduto());
            ps.setInt(2, v.getPedido().getIdPedido());
            ps.setInt(3, v.getQtdProduto());
            ps.setFloat(4, v.getValorTotal());
            ps.executeUpdate();

            String sql2 = "update pedido set status = 1"
                    + "where idPedido=?;";
            PreparedStatement ps2 = getConexao().prepareStatement(sql2);
            ps2.setInt(1, v.getPedido().getIdPedido());
            ps2.executeUpdate();

        }

        return true;

    }

    public ArrayList<Vendas> pesquisar(String pesq) throws Exception {
        ArrayList<Vendas> lista = new ArrayList<>();
        String sql = "select * from vendas where idPedido=" + pesq;
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            int idProduto = rs.getInt("idProduto");
            int idPedido = rs.getInt("idPedido");

            Produto objProduto = new Produto();
            Pedido objPedido = new Pedido();
            Vendas ven = new Vendas();

            objProduto.setIdProduto(idProduto);
            objPedido.setIdPedido(idPedido);

            Vendas objVendas = new Vendas(rs.getInt("qtdProduto"), rs.getFloat("precoVenda"),
                    objProduto, objPedido);

            lista.add(objVendas);
        }
        return lista;
    }

    public boolean editar(Vendas obj) throws Exception {
        
              
        String sql = "Update vendas set qtdProduto=?,precoVenda=?"
                + " where idPedido=? and idProduto=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getQtdProduto());
        ps.setFloat(2, obj.getValorTotal());
        ps.setInt(3, obj.getPedido().getIdPedido());
        ps.setInt(4, obj.getProduto().getIdProduto());

        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int idPed, int idProd) throws Exception {
        String sql = "Delete from vendas where idPedido=? and idProduto=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, idPed);
        ps.setInt(2, idProd);
        return ps.executeUpdate() > 0;
    }

}

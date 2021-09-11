/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.Fornecedor;
import model.Produto;

/**
 *
 * @author mauri
 */
public class ProdutoData extends Conexao {

    public ProdutoData() throws SQLException, ClassNotFoundException {
    }

    public boolean incluir(Produto obj) throws Exception {
        String sql = "Insert into produto (nomeProduto,preco,quantidade,idFornecedor) values (?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNomeProd());
        ps.setDouble(2, obj.getValorProd());
        ps.setInt(3, obj.getQtdProd());
        ps.setObject(4, obj.getFornecedor().getIdFornecedor());
        return ps.executeUpdate() > 0;
    }

    public Vector<Produto> pesquisarProdutosGeral(String pesq) throws Exception {

        Vector<Produto> lista = new Vector<>();
        String sql = "Select idProduto, nomeProduto,preco, quantidade, f.idFornecedor, f.nomeFornecedor  from produto p "
                + "inner join fornecedor f on(p.idFornecedor = f.idFornecedor) "
                + "where nomeProduto like '" + pesq + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idFornecedor = rs.getInt("idFornecedor");
            String nomeFornecedor = rs.getString("nomeFornecedor");
            Fornecedor objFornecedor = new Fornecedor();
            objFornecedor.setIdFornecedor(idFornecedor);
            objFornecedor.setNomeFornecedor(nomeFornecedor);

            Produto objPedido = new Produto(rs.getInt("idProduto"), rs.getString("nomeProduto"),
                    rs.getFloat("preco"), rs.getInt("quantidade"), objFornecedor);
            lista.add(objPedido);
        }
        return lista;
    }

    //combobox
    public Vector<Produto> pesquisarProdutos() throws Exception {
        Vector<Produto> lista = new Vector<>();
        String sql = "select * from produto WHERE quantidade > 0";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idFornecedor = rs.getInt("idFornecedor");
            Fornecedor objFornecedor = new Fornecedor();
            objFornecedor.setIdFornecedor(idFornecedor);

            Produto objProduto = new Produto(rs.getInt("idProduto"), rs.getString("nomeProduto"),
                    rs.getFloat("preco"), rs.getInt("quantidade"), objFornecedor);
            lista.add(objProduto);

        }
        return lista;
    }

    public boolean editar(Produto obj) throws Exception {
        String sql = "Update produto set nomeProduto=?,preco=?,quantidade=?,idFornecedor=?"
                + " where idProduto=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNomeProd());
        ps.setFloat(2, obj.getValorProd());
        ps.setInt(3, obj.getQtdProd());
        ps.setInt(4, obj.getFornecedor().getIdFornecedor());
        ps.setInt(5, obj.getIdProduto());

        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String sql = "Delete from produto where idProduto=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

}

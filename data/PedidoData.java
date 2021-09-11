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
import model.Pedido;
import model.Produto;
import model.Usuario;

/**
 *
 * @author mauri
 */
public class PedidoData extends Conexao {

    public PedidoData() throws SQLException, ClassNotFoundException {
    }

    public boolean incluir(Pedido obj) throws Exception {
        String sql = "Insert into pedido (dtPedido,formaPagamento,idUsuario, status) values (?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getData());
        ps.setString(2, obj.getFormaPagamento());
        ps.setObject(3, obj.getCliente().getIdPessoa());
        ps.setObject(4, obj.getStatus());

        return ps.executeUpdate() > 0;
    }

    public Vector<Pedido> preencheComboBox(int stat) throws Exception {
        Vector<Pedido> lista = new Vector<>();
        String sql = "Select idPedido, dtPedido,status,formaPagamento, u.idUsuario, u.nome  from pedido p "
                + "inner join pessoa u on(p.idUsuario = u.idUsuario) "
                + "where status = " + stat + " and u.tipo = 1";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idUser = rs.getInt("idUsuario");
            String nome = rs.getString("nome");

            Usuario objUsuario = new Usuario();
            objUsuario.setIdPessoa(idUser);
            objUsuario.setNome(nome);

            Pedido objPedido = new Pedido(rs.getInt("idPedido"), rs.getString("dtPedido"), rs.getInt("status"),
                    rs.getString("formaPagamento"), objUsuario);
            lista.add(objPedido);
        }
        return lista;
    }

    public Vector<Pedido> pesquisarPedidosNaoVendidos(String pesq) throws Exception {
        Vector<Pedido> lista = new Vector<>();
        String sql = "Select idPedido, dtPedido,status,formaPagamento, u.idUsuario, u.nome  from pedido p "
                + "inner join pessoa u on(p.idUsuario = u.idUsuario) "
                + "where u.nome like '" + pesq + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idUser = rs.getInt("idUsuario");
            String nome = rs.getString("nome");

            Usuario objUsuario = new Usuario();
            objUsuario.setIdPessoa(idUser);
            objUsuario.setNome(nome);

            Pedido objPedido = new Pedido(rs.getInt("idPedido"), rs.getString("dtPedido"), rs.getInt("status"),
                    rs.getString("formaPagamento"), objUsuario);
            lista.add(objPedido);
        }
        return lista;
    }

    public boolean editar(Pedido obj) throws Exception {
        String sql = "Update pedido set dtPedido=?,formaPagamento=?,idUsuario=?"
                + " where idPedido=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getData());
        ps.setString(2, obj.getFormaPagamento());
        ps.setInt(3, obj.getCliente().getIdPessoa());
        ps.setInt(4, obj.getIdPedido());

        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String sql = "Delete from pedido where idPedido=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

}

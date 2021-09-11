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
import java.util.Vector;
import model.Fornecedor;

/**
 *
 * @author mauri
 */
public class FornecedorData extends Conexao {

    public FornecedorData() throws SQLException, ClassNotFoundException {
    }

    public boolean incluir(Fornecedor obj) throws Exception {
        String sql = "Insert into fornecedor (nomeFornecedor,cidade,estado) values (?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNomeFornecedor());
        ps.setString(2, obj.getCidade());
        ps.setString(3, obj.getEstado());
        return ps.executeUpdate() > 0;
    }

    public Vector<Fornecedor> pesquisar(String pesq) throws Exception {
        Vector<Fornecedor> lista = new Vector<>();
        String sql;
        if (pesq == "") {
            sql = "select * from fornecedor";
        } else {
            sql = "select * from fornecedor where nomeFornecedor like '" + pesq + "%'";
        }

        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Fornecedor objFornecedor = new Fornecedor(rs.getInt("idFornecedor"), rs.getString("nomeFornecedor"),
                    rs.getString("cidade"), rs.getString("estado"));
            lista.add(objFornecedor);
        }
        return lista;
    }

    public boolean editar(Fornecedor obj) throws Exception {
        String sql = "Update fornecedor set nomeFornecedor=?,cidade=?,estado=?"
                + " where idFornecedor=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNomeFornecedor());
        ps.setString(2, obj.getCidade());
        ps.setString(3, obj.getEstado());
        ps.setInt(4, obj.getIdFornecedor());

        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String sql = "Delete from fornecedor where idFornecedor=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

}

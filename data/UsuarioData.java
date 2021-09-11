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
import model.Usuario;

/**
 *
 * @author mauri
 */
public class UsuarioData extends Conexao {

    public UsuarioData() throws SQLException, ClassNotFoundException {
    }

    public boolean incluir(Usuario obj) throws Exception {
        String sql = "Insert into pessoa (nome,cpf,telefone,email,senha,tipo) values (?,?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);

        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getCpf());
        ps.setString(3, obj.getTelefone());
        ps.setString(4, obj.getEmail());
        ps.setString(5, obj.getSenha());
        ps.setInt(6, obj.getTipo());
        return ps.executeUpdate() > 0;
    }

    public Usuario validarUsuario(String email, String senha) throws Exception {

        // System.out.println("ENTROUU AQUII");
        String sql = "SELECT * FROM pessoa where email=? and senha = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Usuario obj = new Usuario();
            obj.setIdPessoa(rs.getInt("idUsuario"));
            obj.setNome(rs.getString("nome"));
            obj.setCpf(rs.getString("cpf"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setEmail(rs.getString("email"));
            obj.setSenha(rs.getString("senha"));
            obj.setTipo(rs.getInt("tipo"));
            return obj;
        } else {
            return null;
        }
    }
    
       public Vector<Usuario> preencheCombobox() throws Exception {
        Vector<Usuario> lista = new Vector<>();
        String sql = "select * from pessoa where tipo = 1";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario objUsuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"),
                    rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"), rs.getString("senha"), rs.getInt("tipo"));
            lista.add(objUsuario);
        }
        return lista;
    }

    public Vector<Usuario> pesquisarPessoa(String pesq) throws Exception {
        Vector<Usuario> lista = new Vector<>();
        String sql = "select * from pessoa where nome like '" + pesq + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario objUsuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"),
                    rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"), rs.getString("senha"), rs.getInt("tipo"));
            lista.add(objUsuario);
        }
        return lista;
    }

    public boolean editar(Usuario obj) throws Exception {
        String sql = "Update pessoa set nome=?,cpf=?,telefone=?,email=?,senha=?,tipo=?"
                + " where idUsuario=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getCpf());
        ps.setString(3, obj.getTelefone());
        ps.setString(4, obj.getEmail());
        ps.setString(5, obj.getSenha());
        ps.setInt(6, obj.getTipo());
        ps.setInt(7, obj.getIdPessoa());

        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        
        String sql = "Delete from pedido where idUsuario=?";
        String sql2 = "Delete from pessoa where idUsuario=?"; 
        PreparedStatement ps = getConexao().prepareStatement(sql);
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        ps.setInt(1, id);
        ps2.setInt(1, id);
        return ps2.executeUpdate() > 0;
    }

}

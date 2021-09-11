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
public class Usuario {

    private int idPessoa;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private int tipo;

    public Usuario() {
        idPessoa = 0;
        nome = new String();
        cpf = new String();
        telefone = new String();
        email = new String();
        senha = new String();
        tipo = 0;
    }

    public Usuario(int idPessoa, String nome, String cpf, String telefone, String email,  String senha, int tipo) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }
    

}

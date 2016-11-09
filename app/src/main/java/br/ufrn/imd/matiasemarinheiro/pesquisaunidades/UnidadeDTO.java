package br.ufrn.imd.matiasemarinheiro.pesquisaunidades;

import java.io.Serializable;

/**
 * Created by joaomatias on 09/11/16.
 */

public class UnidadeDTO implements Serializable {

    private int codigo;
    private String nome;
    private String email;
    private String telefone;

    public UnidadeDTO(int codigo, String nome, String email, String telefone){
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

package br.com.jpaBanco.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedor {

    @Id
    private String codigo;
    private String cpf;
    private String nome;
    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Vendedor() {
        // TODO Auto-generated constructor stub
    }

    public Vendedor(String codigo, String cpf, String nome, List<Endereco> enderecos) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.enderecos = enderecos;
    }

    public Vendedor(String codigo, String cpf, String nome) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Vendedor(String cpf, String nome, List<Endereco> enderecos) {
        this.cpf = cpf;
        this.nome = nome;
        this.enderecos = enderecos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }


    @Override
    public String toString() {
        return this.codigo.concat(" -- " + this.nome).concat(" -- " + this.cpf);
    }

}
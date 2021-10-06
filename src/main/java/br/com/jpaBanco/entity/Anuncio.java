package br.com.jpaBanco.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String titulo;
    private BigDecimal preco;
    private LocalDate data_anuncio;
    private Integer num_vendas;
    @ManyToOne
    @JoinColumn(name = "vendedor_codigo")
    private Vendedor vendedor;

    public Anuncio() {
    }

    public Anuncio(Long id, String codigo, String titulo, BigDecimal preco, LocalDate data_anuncio, Integer num_vendas, Vendedor vendedor) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.preco = preco;
        this.data_anuncio = data_anuncio;
        this.num_vendas = num_vendas;
        this.vendedor = vendedor;
    }

    public Anuncio(String codigo, String titulo, BigDecimal preco, LocalDate data_anuncio, Integer num_vendas, Vendedor vendedor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.preco = preco;
        this.data_anuncio = data_anuncio;
        this.num_vendas = num_vendas;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getData_anuncio() {
        return data_anuncio;
    }

    public void setData_anuncio(LocalDate data_anuncio) {
        this.data_anuncio = data_anuncio;
    }

    public Integer getNum_vendas() {
        return num_vendas;
    }

    public void setNum_vendas(Integer num_vendas) {
        this.num_vendas = num_vendas;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}

package br.com.jpaBanco.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estamos informando ao RDBMS que o id será gerado automaticamente
    private Long id;
    private LocalDate data;
    private BigDecimal valorTotal;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    public Venda() {
        super();
    }

    public Venda(Long id, LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento) {
        super();
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }
    public Venda(LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento) {
        super();
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
package com.tavar3slucas.ecomm.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="endero_de_entrega_id")
    private Endereco endecodeEntrega;

    public Pedido(){}

    public Pedido(Integer id, Date instante, Cliente cliente, Endereco endecodeEntrega) {
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.endecodeEntrega = endecodeEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndecodeEntrega() {
        return endecodeEntrega;
    }

    public void setEndecodeEntrega(Endereco endecodeEntrega) {
        this.endecodeEntrega = endecodeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

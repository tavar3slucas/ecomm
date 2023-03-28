package com.tavar3slucas.ecomm.domain;

import com.tavar3slucas.ecomm.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class PagamentoComCartao extends Pagamento{

    private static final long serialVersionUID = 1l;

    private Integer numeroDeParcelas;

    public PagamentoComCartao(Integer pagamento, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(pagamento, estado,pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComCartao() {
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}

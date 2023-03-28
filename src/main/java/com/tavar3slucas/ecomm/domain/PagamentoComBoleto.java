package com.tavar3slucas.ecomm.domain;

import com.tavar3slucas.ecomm.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento{

    private static final long serialVersionUID = 1l;

    private Date dataVencimento;
    private Date dataPagamento;


    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,Date dataVencimento, Date datadataPagamento) {
       super(id,estado,pedido);
        this.dataPagamento = datadataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public PagamentoComBoleto() {
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

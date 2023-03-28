package com.tavar3slucas.ecomm.service;

import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.domain.Pedido;
import com.tavar3slucas.ecomm.repository.CategoriaRepository;
import com.tavar3slucas.ecomm.repository.PedidoRepository;
import com.tavar3slucas.ecomm.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Integer id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado ! Id: " + id + ", Tipo:" + Pedido.class.getName()));

    }
}

package com.tavar3slucas.ecomm.controller;

import com.tavar3slucas.ecomm.domain.Pedido;
import com.tavar3slucas.ecomm.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> find(@PathVariable Integer id){
        Pedido obj = pedidoService.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}

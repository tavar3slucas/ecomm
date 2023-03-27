package com.tavar3slucas.ecomm.controller;

import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.domain.Cliente;
import com.tavar3slucas.ecomm.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

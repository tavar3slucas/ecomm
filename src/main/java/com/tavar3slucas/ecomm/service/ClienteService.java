package com.tavar3slucas.ecomm.service;

import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.domain.Cliente;
import com.tavar3slucas.ecomm.repository.ClienteRepository;
import com.tavar3slucas.ecomm.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado ! Id: " + id + ", Tipo:" + Cliente.class.getName()));
    }
}

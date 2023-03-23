package com.tavar3slucas.ecomm.service;

import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.repository.CategoriaRepository;
import com.tavar3slucas.ecomm.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado ! Id: " + id + ", Tipo:" + Categoria.class.getName()));

    }
}

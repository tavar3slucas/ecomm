package com.tavar3slucas.ecomm.controller;

import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar (){
        Categoria cat1 = new Categoria(1,"Informática");
        Categoria cat2 = new Categoria(2,"Escritório");
        List<Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> listar (@PathVariable("id") Integer id){
        Categoria categoria = categoriaService.find(id);
        return ResponseEntity.ok().body(categoria) ;
    }
}

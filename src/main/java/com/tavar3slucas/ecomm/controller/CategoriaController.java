package com.tavar3slucas.ecomm.controller;

import com.tavar3slucas.ecomm.controller.DTO.CategoriaDTO;
import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> findAll (){
        List<Categoria> categoriaList = categoriaService.findAll();
        List<CategoriaDTO> listDto = categoriaList.stream().map(obj ->
                new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> listar (@PathVariable("id") Integer id){
        Categoria categoria = categoriaService.find(id);
        return ResponseEntity.ok().body(categoria) ;
    }

    @PostMapping
    public ResponseEntity<Void> createCategoria(@RequestBody Categoria obj){
        obj = categoriaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCategoria(@RequestBody Categoria obj, @PathVariable Integer id){
        obj.setId(id);
        obj = categoriaService.update(obj);
       return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
       categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

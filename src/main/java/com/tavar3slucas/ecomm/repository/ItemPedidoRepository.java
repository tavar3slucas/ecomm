package com.tavar3slucas.ecomm.repository;

import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}

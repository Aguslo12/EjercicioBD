package com.example.ejer03.repositories;

import com.example.ejer03.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {
}

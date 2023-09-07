package com.example.ejer03.repositories;

import com.example.ejer03.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository <DetallePedido, Long> {
}

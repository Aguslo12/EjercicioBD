package com.example.ejer03.repositories;

import com.example.ejer03.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Long> {
}

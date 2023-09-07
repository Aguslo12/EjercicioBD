package com.example.ejer03.repositories;

import com.example.ejer03.entities.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository <Rubro, Long> {
}

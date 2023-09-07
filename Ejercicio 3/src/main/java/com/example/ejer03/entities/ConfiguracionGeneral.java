package com.example.ejer03.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfiguracionGeneral extends EntidadBase{

    private int cantidadCocineros;
    private String emailEmpresa;
    private String tokenMercadoPago;
}

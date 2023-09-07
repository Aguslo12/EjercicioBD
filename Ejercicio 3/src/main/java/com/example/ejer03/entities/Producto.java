package com.example.ejer03.entities;

import com.example.ejer03.enums.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends EntidadBase{

    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockAnual;
    private int stockMinimo;
    private String unidadMedida;
    private String foto;
    private String receta;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

}

package com.example.ejer03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido extends EntidadBase{

    private int cantidad;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto producto;
}

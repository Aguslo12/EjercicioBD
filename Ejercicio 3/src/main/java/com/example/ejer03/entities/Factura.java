package com.example.ejer03.entities;

import com.example.ejer03.enums.FormaPago;
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
public class Factura extends EntidadBase {

    //DateTime
    private String fecha;
    private int numero;
    private double descuento;
    private int total;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
}

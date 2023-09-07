package com.example.ejer03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Domicilio extends EntidadBase{

    private String calle;
    private String numero;
    private String localidad;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilioId")
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
}

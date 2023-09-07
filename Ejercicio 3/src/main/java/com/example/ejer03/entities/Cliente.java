package com.example.ejer03.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Cliente extends EntidadBase{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "clienteId")
    private List<Pedido> pedidos = new ArrayList<>();

}

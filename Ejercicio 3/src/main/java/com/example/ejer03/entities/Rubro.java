package com.example.ejer03.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubro extends EntidadBase{

    private String denominacion;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "productoId")
    private List<Producto> productos = new ArrayList<>();

}

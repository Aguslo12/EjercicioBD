package com.example.ejer03.entities;

import com.example.ejer03.enums.Estado;
import com.example.ejer03.enums.TipoEnvio;
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
public class Pedido extends EntidadBase{

    private String fecha;
    private String horaEstimadaEntrega;
    private Double total;
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facturaId")
    private Factura factura;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedidoId")
    private List<DetallePedido> detallesPedidos = new ArrayList<>();


}

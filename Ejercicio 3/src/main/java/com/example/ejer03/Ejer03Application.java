package com.example.ejer03;

import com.example.ejer03.entities.*;
import com.example.ejer03.enums.Estado;
import com.example.ejer03.enums.FormaPago;
import com.example.ejer03.enums.Tipo;
import com.example.ejer03.enums.TipoEnvio;
import com.example.ejer03.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class Ejer03Application {

    @Autowired
    ClienteRepository clienteRepositorio;

    @Autowired
    ConfiguracionGeneralRepository configuracionGeneralRepositorio;

    @Autowired
    DetallePedidoRepository detallePedidoRepositorio;

    @Autowired
    DomicilioRepository domicilioRepositorio;

    @Autowired
    FacturaRepository facturaRepositorio;

    @Autowired
    PedidoRepository pedidoRepositorio;

    @Autowired
    ProductoRepository productoRepositorio;

    @Autowired
    RubroRepository rubroRepositorio;

    @Autowired
    UsuarioRepository usuarioRepositorio;

    public static void main(String[] args) {
        SpringApplication.run(Ejer03Application.class, args);
    }

    @Bean
    CommandLineRunner demo() {
        return args -> {

            //Patrón de diseño builder
            Producto producto = Producto.builder()
                    .precioCompra(250)
                    .precioVenta(500)
                    .stockMinimo(5)
                    .stockAnual(25)
                    .receta("Prepizza, Queso, Salsa")
                    .tiempoEstimadoCocina(80)
                    .foto("FOTO")
                    .tipo(Tipo.INSUMO)
                    .denominacion("Pizza")
                    .unidadMedida("kg")
                    .build();
            productoRepositorio.save(producto);

            DetallePedido detallePedido = DetallePedido.builder()
                    .cantidad(1)
                    .producto(producto)
                    .subtotal(500.0)
                    .build();
            detallePedidoRepositorio.save(detallePedido);

            Factura factura = Factura.builder()
                    .descuento(0)
                    .numero(2312)
                    .formaPago(FormaPago.ETC)
                    .fecha("7/9/2023")
                    .total(500)
                    .build();
            facturaRepositorio.save(factura);

            Pedido pedido = Pedido.builder()
                    .fecha("7/9/2023")
                    .estado(Estado.PREPARACION)
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    .detallesPedidos(new ArrayList<>())
                    .total(1.0)
                    .horaEstimadaEntrega("00:00")
                    .factura(factura)
                    .build();
            pedido.getDetallesPedidos().add(detallePedido);
            pedidoRepositorio.save(pedido);

            Rubro rubro = Rubro.builder()
                    .denominacion("Alimentos")
                    .productos(new ArrayList<>())
                    .build();
            rubro.getProductos().add(producto);
            rubroRepositorio.save(rubro);

            Usuario usuario = Usuario.builder()
                    .nombre("Juan Cruz Castellanos")
                    .password("ChinchulinArrugado")
                    .pedidos(new ArrayList<>())
                    .build();
            usuario.getPedidos().add(pedido);
            usuarioRepositorio.save(usuario);

            Cliente cliente = Cliente.builder()
                    .apellido("Castellanos")
                    .nombre("Juan Cruz")
                    .email("juancruz@gmail.com")
                    .pedidos(new ArrayList<>())
                    .telefono("2615421829")
                    .build();
            cliente.getPedidos().add(pedido);
            clienteRepositorio.save(cliente);

            Domicilio domicilio = Domicilio.builder()
                    .calle("B. de Los Andes")
                    .localidad("Guaymallen")
                    .numero("5231")
                    .pedidos(new ArrayList<>())
                    .cliente(cliente)
                    .build();
            domicilio.getPedidos().add(pedido);
            // Guardar el objeto en la base de datos
            domicilioRepositorio.save(domicilio);


            try {
                Optional<Rubro> rubroRecuperado = rubroRepositorio.findById(rubro.getId());
                Optional<Usuario> usuarioRecuperado = usuarioRepositorio.findById(usuario.getId());
                Optional<Cliente> clienteRecuperado = clienteRepositorio.findById(cliente.getId());
                Optional<Pedido> pedidoRecuperado = pedidoRepositorio.findById(pedido.getId());
                Optional<Factura> facturaRecuperado = facturaRepositorio.findById(factura.getId());
                Optional<DetallePedido> detallePedidoRecuperado = detallePedidoRepositorio.findById(detallePedido.getId());
                Optional<Producto> productoRecuperado = productoRepositorio.findById(producto.getId());
                Optional<Domicilio> domicilioRecuperado = domicilioRepositorio.findById(domicilio.getId());
                if (rubroRecuperado.isPresent()) {
                    Rubro rubro1 = rubroRecuperado.get();
                    System.out.println(rubro1);
                }
                else if (usuarioRecuperado.isPresent()) {
                    Usuario usuario1 = usuarioRecuperado.get();
                    System.out.println(usuario1);
                }
                else if (clienteRecuperado.isPresent()) {
                    Cliente cliente1 = clienteRecuperado.get();
                    System.out.println(cliente1);
                }
                else if (pedidoRecuperado.isPresent()) {
                    Pedido pedido1 = pedidoRecuperado.get();
                    System.out.println(pedido1);
                }
                else if (facturaRecuperado.isPresent()){
                    Factura factura1 = facturaRecuperado.get();
                    System.out.println(factura1);
                }
                else if (detallePedidoRecuperado.isPresent()) {
                    DetallePedido detallePedido1 = detallePedidoRecuperado.get();
                    System.out.println(detallePedido1);
                }
                else if (productoRecuperado.isPresent()) {
                    Producto producto1 = productoRecuperado.get();
                    System.out.println(producto1);
                }
                else {
                    Domicilio domicilio1 = domicilioRecuperado.get();
                    System.out.println(domicilio1);
                }
            } catch (Exception e) {
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        };
    }

}



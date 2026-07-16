package com.tapia.lab1.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.tapia.lab1.model.Pedido;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PedidoRepositoryTest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void should_find_pedidos_by_estado() {
        // Arrange: guarda 2 pedidos PENDIENTE y 1 pedido PAGADO
        pedidoRepository.save(new Pedido("Ana", 25.0, "PENDIENTE"));
        pedidoRepository.save(new Pedido("Luis", 30.0, "PENDIENTE"));
        pedidoRepository.save(new Pedido("Marta", 45.0, "PAGADO"));

        // Act: invoca pedidoRepository.findByEstado("PENDIENTE")
        List<Pedido> pedidosPendientes = pedidoRepository.findByEstado("PENDIENTE");

        // Assert: verifica que el resultado contenga exactamente 2 pedidos
        assertThat(pedidosPendientes)
                .hasSize(2)
                .extracting(Pedido::getEstado)
                .containsOnly("PENDIENTE");
    }
}

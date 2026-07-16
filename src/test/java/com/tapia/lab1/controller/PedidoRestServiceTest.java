package com.tapia.lab1.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.tapia.lab1.model.Pedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PedidoRestServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void should_create_pedido_end_to_end() {
        // Arrange
        Pedido nuevo = new Pedido("Sofía", 60.0, "PENDIENTE");

        // Act
        ResponseEntity<Pedido> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/pedidos", nuevo, Pedido.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getCliente()).isEqualTo("Sofía");
    }
}

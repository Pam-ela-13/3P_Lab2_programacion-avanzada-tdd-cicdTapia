package com.tapia.lab1.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tapia.lab1.model.Pedido;
import com.tapia.lab1.service.PedidoService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoService pedidoService;

    @Test
    void should_return_pedidos_pendientes() throws Exception {
        // Arrange: simula PedidoService para devolver un pedido pendiente
        given(pedidoService.obtenerPorEstado("PENDIENTE"))
                .willReturn(List.of(new Pedido(1L, "Ana", 25.0, "PENDIENTE")));

        // Act: ejecuta una peticion GET a /api/pedidos con estado PENDIENTE
        var resultActions = mockMvc.perform(get("/api/pedidos").param("estado", "PENDIENTE"));

        // Assert: verifica estado HTTP 200 y que el primer cliente sea Ana
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cliente").value("Ana"));
    }
}

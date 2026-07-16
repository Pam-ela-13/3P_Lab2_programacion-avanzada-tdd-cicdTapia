package com.tapia.lab1.controller;

import com.tapia.lab1.model.Pedido;
import com.tapia.lab1.service.PedidoService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {

        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> porEstado(@RequestParam String estado) {

        return pedidoService.obtenerPorEstado(estado);
    }
}

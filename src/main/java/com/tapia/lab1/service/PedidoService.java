package com.tapia.lab1.service;

import com.tapia.lab1.model.Pedido;
import com.tapia.lab1.repository.PedidoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {

        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> obtenerPorEstado(String estado) {

        return pedidoRepository.findByEstado(estado);
    }
}

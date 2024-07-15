package br.pucrs.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.edu.entity.Pedido;
import br.pucrs.edu.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}	

}

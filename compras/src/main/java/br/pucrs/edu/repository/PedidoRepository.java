package br.pucrs.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucrs.edu.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

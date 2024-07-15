package br.pucrs.edu.controller.dto.output;

import java.time.Instant;

import br.pucrs.edu.entity.Pedido;
import lombok.Data;

@Data
public class PedidoOutputDto {
	
	private long identificador;
	private long usuario;
	private long situacao;
	private double total; 
	private Instant dataCriacao;
	
	//private List<>

	public PedidoOutputDto() {
		
	}
	
	
	public PedidoOutputDto (Pedido pedido) {
		this.identificador = pedido.getIdentificador();
		this.usuario = pedido.getUsuario();
		this.situacao = pedido.getSituacao();
		this.total = pedido.getTotal();
		this.dataCriacao = pedido.getDataCriacao();
	}
	

	
	
}

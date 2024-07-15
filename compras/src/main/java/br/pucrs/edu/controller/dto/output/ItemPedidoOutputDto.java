package br.pucrs.edu.controller.dto.output;

import br.pucrs.edu.entity.ItemPedido;

public class ItemPedidoOutputDto {

	private long situacao;
	private int quantidade; 
	
	
	public ItemPedidoOutputDto() {
		
	}
	
	
	public ItemPedidoOutputDto(ItemPedido itemPedido) {
		this.situacao = itemPedido.getSituacao();
		this.quantidade = itemPedido.getQuantidade();
	}

}

package br.pucrs.edu.controller.dto.input;

import lombok.Data;

@Data
public class ItemPedidoInputDto {
	
	private long situacao;
	private int quantidade; 
	
	public ItemPedidoInputDto() {
		
	}



}

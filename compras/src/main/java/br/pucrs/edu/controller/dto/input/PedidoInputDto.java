package br.pucrs.edu.controller.dto.input;

import java.util.ArrayList;
import java.util.List;

import br.pucrs.edu.entity.ItemPedido;
import br.pucrs.edu.entity.Pedido;
import lombok.Data;

@Data
public class PedidoInputDto {
	private long usuario;
	private long situacao;
	private double total; 
	private List<ItemPedidoInputDto> itensPedido;		
	public PedidoInputDto() {
		
	}
	
	
	public Pedido build() {		
		Pedido pedido = new Pedido();

		pedido.setUsuario(this.usuario);
		pedido.setSituacao(this.situacao);		
		if(isNotEmpty(itensPedido)) {pedido.setItensPedido(getItensPedido());}
		pedido.setTotal(this.total);
		return pedido;
	}
	
	
    private boolean isNotEmpty(List<ItemPedidoInputDto> itensPedido) {
        if ((itensPedido != null) && (itensPedido.size() > 0)) {
            return true;
        }
        return false;
    }
    
    private List<ItemPedido> getItensPedido(){
    	
    	List<ItemPedido> listaItensPedido = new ArrayList<ItemPedido>();
        
         for(ItemPedidoInputDto itemPedidoDto : itensPedido){
             ItemPedido item = new ItemPedido();
             item.setQuantidade(itemPedidoDto.getQuantidade());
             item.setSituacao(itemPedidoDto.getSituacao());    
             this.total = this.total + (item.getProduto().getValor() * item.getQuantidade());
             listaItensPedido.add(item);
         } 
         return listaItensPedido;
     }

	
}

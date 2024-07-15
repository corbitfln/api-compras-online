package br.pucrs.edu.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.pucrs.edu.controller.dto.input.PedidoInputDto;
import br.pucrs.edu.controller.dto.output.PedidoOutputDto;
import br.pucrs.edu.entity.Pedido;
import br.pucrs.edu.service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	public static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);
	
	@Autowired
	PedidoService pedidoService;
	

	
	@PostMapping(consumes = "application/json", produces = "application/json")	
	public ResponseEntity<PedidoOutputDto> criarPedido(
			 @Valid @RequestBody PedidoInputDto pedidoInputDto,
	            UriComponentsBuilder uriBuilder){
		
		Pedido pedido = pedidoInputDto.build();
		
		pedidoService.salvar(pedido);
				
		 URI path = uriBuilder.path("/requerimentos-pensao/{id}")
	                .buildAndExpand(pedido.getIdentificador()).toUri();		
		
		return ResponseEntity.created(path).body(new PedidoOutputDto(pedido));
	}
}

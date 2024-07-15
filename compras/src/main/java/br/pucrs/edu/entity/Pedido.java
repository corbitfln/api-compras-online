package br.pucrs.edu.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="identificador")
    private Long identificador;
    private Instant dataCriacao = Instant.now();
    private Long usuario; 
    private Long situacao;
    private Double total;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_identificador")
    private List<ItemPedido> itensPedido;
    
    public Pedido() {
    	super();
    }
	
}

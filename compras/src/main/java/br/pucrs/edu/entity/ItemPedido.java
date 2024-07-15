package br.pucrs.edu.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="itempedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;
    private Long situacao;     
    private int quantidade;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itempedido_produto_identificador")
    private Produto produto;
    
    public ItemPedido() {
    	super();
    }


}

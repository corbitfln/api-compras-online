package br.pucrs.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;
    private String descricao;
    private Double valor;

    
    public Produto() {
    	super();
    }
    
}

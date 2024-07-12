package br.pucrs.edu.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	private String cpf;
	private String email;
	private String senha; 	
	
	public Usuario() {
		super();
	}
	
}
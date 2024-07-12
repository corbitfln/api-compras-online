package br.pucrs.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucrs.edu.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}

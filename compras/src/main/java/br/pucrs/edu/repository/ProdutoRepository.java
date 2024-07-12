package br.pucrs.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucrs.edu.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

package br.com.daniel.model.repository;

import br.com.daniel.model.entity.Cliente;
import br.com.daniel.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Integer> {
}

package br.com.daniel.model.repository;

import br.com.daniel.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado,Integer> {
}

package com.ryanmiranda.financas_on.repository;

import com.ryanmiranda.financas_on.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(String nome);
}

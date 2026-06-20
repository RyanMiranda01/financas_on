package com.ryanmiranda.financas_on.repository;

import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.model.Transacao;
import com.ryanmiranda.financas_on.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<Transacao, Long> {

    Usuario findByUsuarioId(Long id);

    Categoria findByCategoriaId(Long id);

}

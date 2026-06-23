package com.ryanmiranda.financas_on.repository;

import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.model.Tipo;
import com.ryanmiranda.financas_on.model.Transacao;
import com.ryanmiranda.financas_on.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;


public interface TransacoesRepository extends JpaRepository<Transacao, Long> {

    Usuario findByUsuarioId(Long id);

    Categoria findByCategoriaId(Long id);

    @Query("""
            SELECT t
            FROM Transacao t
            WHERE MONTH(t.data) = :mes
            """)
    Page<Transacao> buscarPorMes(@Param("mes") int mes, Pageable pageable);

    @Query("""
            SELECT t
            FROM Transacao t
            WHERE YEAR(t.data) = :ano
            """)
    Page<Transacao> buscarPorAno(@Param("ano") int ano, Pageable pageable);

    @Query("""
             SELECT     
                t
             FROM Transacao t
             WHERE t.categoria.nome = :categoria
            """)
    Page<Transacao> buscarPorCategoria(@Param("categoria") String categoria, Pageable pageable);

    Page<Transacao> findByTipo(Tipo tipo, Pageable pag);

    @Query("""
             SELECT     
                t
             FROM Transacao t
             WHERE t.valor >= :valor
            """)
    Page<Transacao> buscarPorValorMinimo(double valor, Pageable pag);


    @Query("""
             SELECT     
                t
             FROM Transacao t
             WHERE t.valor <= :valor
            """)
    Page<Transacao> buscarPorValorMaximo(double valor, Pageable pageable);

    List<Transacao> findByTipo(Tipo tipoEscolhido);
}

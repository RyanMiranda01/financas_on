package com.ryanmiranda.financas_on.DTOs.TransicoesDTO;

import com.ryanmiranda.financas_on.model.Tipo;
import com.ryanmiranda.financas_on.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ListarTransicoes(
        String descricao,
        BigDecimal valor,
        Tipo tipo,
        LocalDate date,
        Long id_usuario,
        Long id_categoria
) {

    public ListarTransicoes(Transacao transacao) {
        this(transacao.getDescricao(), transacao.getValor(), transacao.getTipo(), transacao.getData(), transacao.getUsuario().getId(), transacao.getCategoria().getId());
    }

}

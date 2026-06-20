package com.ryanmiranda.financas_on.DTOs.TransicoesDTO;

import java.math.BigDecimal;

public record AtualizarTransicao(
        String descricao,
        BigDecimal valor
) {
}

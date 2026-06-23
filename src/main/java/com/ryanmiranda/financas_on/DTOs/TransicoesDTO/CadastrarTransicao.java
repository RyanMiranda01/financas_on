package com.ryanmiranda.financas_on.DTOs.TransicoesDTO;

import com.ryanmiranda.financas_on.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastrarTransicao(
        @NotBlank
        String descricao,
        @NotNull
        BigDecimal valor,
        @NotNull
        Tipo tipo,
        @NotNull
        LocalDate data,
        @NotNull
        Long id_categoria,
        @NotNull
        Long id_usuario

) {
}

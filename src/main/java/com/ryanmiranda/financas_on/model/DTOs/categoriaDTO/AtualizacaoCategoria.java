package com.ryanmiranda.financas_on.model.DTOs.categoriaDTO;

import com.ryanmiranda.financas_on.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoCategoria(@NotNull Long id, @NotBlank String nome, @NotBlank Tipo tipo) {
}

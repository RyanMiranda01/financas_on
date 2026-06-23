package com.ryanmiranda.financas_on.DTOs.categoriaDTO;


import com.ryanmiranda.financas_on.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroCategoria(
        @NotBlank
         String nome,
         @NotNull
         Tipo tipo,
         @NotNull
        Long usuarioId,
        @NotNull
        LocalDate data
) {
}

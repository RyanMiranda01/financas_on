package com.ryanmiranda.financas_on.DTOs.categoriaDTO;


import com.ryanmiranda.financas_on.model.Tipo;
import com.ryanmiranda.financas_on.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroCategoria(
        @NotBlank
         String nome,
         @NotNull
         Tipo tipo,
         @NotNull
        Long usuarioId
) {
}

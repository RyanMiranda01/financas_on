package com.ryanmiranda.financas_on.DTOs.UsuarioDTO;

import jakarta.validation.constraints.Email;

public record AtualizacaoUsuario(
        String nome,
        @Email
        String email
) {
}

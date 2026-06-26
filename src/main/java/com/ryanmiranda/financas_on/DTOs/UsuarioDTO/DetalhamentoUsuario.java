package com.ryanmiranda.financas_on.DTOs.UsuarioDTO;

import com.ryanmiranda.financas_on.model.Usuario;

public record DetalhamentoUsuario(Long id, String nome, String email) {

    public DetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
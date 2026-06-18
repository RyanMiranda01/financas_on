package com.ryanmiranda.financas_on.DTOs.UsuarioDTO;

import com.ryanmiranda.financas_on.model.Usuario;

public record ListarDadosUsuario(String nome, String email) {

    public ListarDadosUsuario(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail());
    }
}

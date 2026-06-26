package com.ryanmiranda.financas_on.DTOs.categoriaDTO;

import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.model.Tipo;
import com.ryanmiranda.financas_on.model.Usuario;

public record DetalhamentoCategoria(Long id, String nome, Tipo tipo, Long usuario) {

    public DetalhamentoCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getNome(), categoria.getTipo(), categoria.getUsuario().getId());
    }
}

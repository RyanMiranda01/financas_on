package com.ryanmiranda.financas_on.model.DTOs.categoriaDTO;

import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.model.Tipo;

public record ListarCategoria(String nome, Tipo tipo) {

   public ListarCategoria(Categoria categoria){
        this(categoria.getNome(), categoria.getTipo());
    }
}

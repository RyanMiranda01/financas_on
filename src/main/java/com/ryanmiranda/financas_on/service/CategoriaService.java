package com.ryanmiranda.financas_on.service;

import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.model.DTOs.categoriaDTO.AtualizacaoCategoria;
import com.ryanmiranda.financas_on.model.DTOs.categoriaDTO.CadastroCategoria;
import com.ryanmiranda.financas_on.model.DTOs.categoriaDTO.ListarCategoria;
import com.ryanmiranda.financas_on.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public boolean cadastrarCategoria(CadastroCategoria cadastroCategoria){
       categoriaRepository.save(new Categoria(cadastroCategoria));
       return true;
    }

    public boolean editarCategoria(Long id, AtualizacaoCategoria atualizacaoCategoria){
        var categoria = categoriaRepository.getReferenceById(id);
        categoria.atualizarCategoria(atualizacaoCategoria);
        return true;
    }

    public boolean deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
        return true;
    }

    public Page<ListarCategoria> listarCategorias(Pageable pagina){
        return categoriaRepository.findAll(pagina).map(ListarCategoria::new);
    }



}

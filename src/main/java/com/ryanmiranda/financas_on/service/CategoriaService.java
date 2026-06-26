package com.ryanmiranda.financas_on.service;

import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.ListarDadosUsuario;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.DetalhamentoCategoria;
import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.AtualizacaoCategoria;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.CadastroCategoria;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.ListarCategoria;
import com.ryanmiranda.financas_on.model.Usuario;
import com.ryanmiranda.financas_on.repository.CategoriaRepository;
import com.ryanmiranda.financas_on.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public Categoria cadastrarCategoria(CadastroCategoria cadastroCategoria) {

        if (verificarCategoria(cadastroCategoria.nome())) {
            throw new RuntimeException("Categoria já cadastrada");
        }

        Usuario usuario = usuarioRepository.getReferenceById(cadastroCategoria.usuarioId());
        var categoria = new Categoria(cadastroCategoria, usuario);
        categoriaRepository.save(categoria);
        return categoria;
    }

    public boolean editarCategoria(Long id, AtualizacaoCategoria atualizacaoCategoria) {

        if (verificarCategoria(atualizacaoCategoria.nome())) {
            return false;
        }

        var categoria = categoriaRepository.getReferenceById(id);

        if (categoria == null) {
            return false;
        } else {
            categoria.atualizarCategoria(atualizacaoCategoria);
            return true;
        }
    }

    public boolean deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
        return true;
    }

    public Page<ListarCategoria> listarCategorias(Pageable pagina) {
        return categoriaRepository.findAll(pagina).map(ListarCategoria::new);
    }

    public DetalhamentoCategoria listarCategoriaId(Long id) {
        DetalhamentoCategoria categoria = new DetalhamentoCategoria(categoriaRepository.findById(id).get());
        return categoria;
    }

    public boolean verificarCategoria(String nome) {
        boolean existe = categoriaRepository.existsByNome(nome);
        if (existe) {
            return true;
        } else {
            return false;
        }
    }


}

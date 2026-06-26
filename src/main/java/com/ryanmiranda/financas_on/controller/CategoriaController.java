package com.ryanmiranda.financas_on.controller;


import com.ryanmiranda.financas_on.DTOs.categoriaDTO.DetalhamentoCategoria;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.AtualizacaoCategoria;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.CadastroCategoria;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.ListarCategoria;
import com.ryanmiranda.financas_on.service.CategoriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("financason/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity cadastrarCategoria(@RequestBody @Valid CadastroCategoria cadastroCategoria, UriComponentsBuilder uriComponentsBuilder) {
       var categoria = categoriaService.cadastrarCategoria(cadastroCategoria);

        var uri = uriComponentsBuilder.path("financason/categoria/cadastrar/{id}").buildAndExpand(categoria.getId()).toUri();

            return ResponseEntity.created(uri).body(new DetalhamentoCategoria(categoria));

    }

    @GetMapping("listar")
    public ResponseEntity<Page<ListarCategoria>> listarCategorias(Pageable pagina) {
        var page = categoriaService.listarCategorias(pagina);
        return ResponseEntity.ok(page);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity listarCategoriaId(@PathVariable Long id) {
       var page = categoriaService.listarCategoriaId(id);
       return ResponseEntity.ok(page);
    }


    @PutMapping("editar/{id}")
    @Transactional
    public ResponseEntity editar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCategoria atualizacaoCategoria) {

        var categoria = categoriaService.editarCategoria(id, atualizacaoCategoria);
        return ResponseEntity.ok(categoria);

    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity deletarCategoria(@PathVariable Long id){
         categoriaService.deletarCategoria(id);
         return ResponseEntity.noContent().build();
    }


}
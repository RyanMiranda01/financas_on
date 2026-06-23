package com.ryanmiranda.financas_on.controller;


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

@RestController
@RequestMapping("financason/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrarCategoria(@RequestBody @Valid CadastroCategoria cadastroCategoria) {

        if (categoriaService.cadastrarCategoria(cadastroCategoria)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Categoria cadastrada com sucesso!");
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Algum erro no cadastro!");
        }
    }

    @GetMapping("listar")
    public Page<ListarCategoria> listarCategorias(Pageable pagina) {
        return categoriaService.listarCategorias(pagina);
    }

    @GetMapping("listar/{id}")
    public ListarCategoria listarCategoriaId(@PathVariable Long id) {
        return categoriaService.listarCategoriaId(id);
    }


    @PutMapping("editar/{id}")
    @Transactional
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCategoria atualizacaoCategoria) {

        if (categoriaService.editarCategoria(id, atualizacaoCategoria)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Categoria atualizada com sucesso!");
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Algum erro na atualização!");
        }


    }

    @DeleteMapping("deletar/{id}")
    public void deletarCategoria(@PathVariable Long id){
         categoriaService.deletarCategoria(id);
    }


}
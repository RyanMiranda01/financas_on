package com.ryanmiranda.financas_on.controller;

import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.AtualizacaoUsuario;
import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.DetalhamentoUsuario;
import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.ListarDadosUsuario;
import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.CadastroUsuario;
import com.ryanmiranda.financas_on.service.UsuarioService;
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
@RequestMapping("financason/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid CadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriComponentsBuilder){
       var usuario = usuarioService.cadastrarUsuario(dadosCadastroUsuario);
       var uri = uriComponentsBuilder.path("financason/usuario/cadastrar/{id}").buildAndExpand(usuario.getId()).toUri();

       return ResponseEntity.created(uri).body(new DetalhamentoUsuario(usuario));
    }


    @GetMapping("listar")
    public ResponseEntity<Page<ListarDadosUsuario>> listarUsuarios(Pageable pageable){
        var u = usuarioService.listarUsuarios(pageable);
        return ResponseEntity.ok(u);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity listarDadosUsuariosId(@PathVariable Long id){
        var u = usuarioService.listarUsuariosId(id);
       return ResponseEntity.ok(u);

    }

    @PutMapping("editar/{id}")
    @Transactional
    public ResponseEntity editarUsuario(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuario dadoAtualizacao){

        var usuario = usuarioService.atualizarUsuario(id, dadoAtualizacao);

        return ResponseEntity.ok(usuario);

    }

    @DeleteMapping("deletar/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }


}

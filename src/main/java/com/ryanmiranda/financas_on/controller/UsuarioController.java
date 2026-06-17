package com.ryanmiranda.financas_on.controller;

import com.ryanmiranda.financas_on.model.DTOs.UsuarioDTO.AtualizacaoUsuario;
import com.ryanmiranda.financas_on.model.DTOs.UsuarioDTO.ListarDadosUsuario;
import com.ryanmiranda.financas_on.model.DTOs.UsuarioDTO.CadastroUsuario;
import com.ryanmiranda.financas_on.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("financason/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid CadastroUsuario dadosCadastroUsuario){
        if(usuarioService.cadastrarUsuario(dadosCadastroUsuario)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Usuário cadastrado com sucesso!");
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email já cadastrado");
        }
    }


    @GetMapping("listar")
    public Page<ListarDadosUsuario> listarUsuarios(Pageable pageable){
        return usuarioService.listarUsuarios(pageable);
    }

    @GetMapping("listar/{id}")
    public ListarDadosUsuario listarDadosUsuariosId(@PathVariable Long id){
       return usuarioService.listarUsuariosId(id);

    }

    @PutMapping("editar/{id}")
    @Transactional
    public ResponseEntity<String> editarUsuario(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuario dadoAtualizacao){

        if(usuarioService.atualizarUsuario(id, dadoAtualizacao)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Usuário aualizado com sucesso!");
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email já cadastrado ou Usuario inexistente");
        }
    }

    @DeleteMapping("deletar/{id}")
    @Transactional
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }


}

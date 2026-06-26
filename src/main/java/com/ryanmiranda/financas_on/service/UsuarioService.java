package com.ryanmiranda.financas_on.service;

import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.AtualizacaoUsuario;
import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.CadastroUsuario;
import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.DetalhamentoUsuario;
import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.ListarDadosUsuario;
import com.ryanmiranda.financas_on.model.Usuario;
import com.ryanmiranda.financas_on.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(CadastroUsuario dadosCadastroUsuario) {

        if (usuarioRepository.existsByEmail(dadosCadastroUsuario.email())) {
            throw new RuntimeException("Usuário não cadastrado");
        } else {
            var user = new Usuario(dadosCadastroUsuario);
            usuarioRepository.save(user);
            return user;
        }
    }

    public Page<ListarDadosUsuario> listarUsuarios(Pageable pagina) {
        return usuarioRepository.findAll(pagina).map(ListarDadosUsuario::new);
    }

    public DetalhamentoUsuario listarUsuariosId(Long id) {
        var user = new DetalhamentoUsuario(usuarioRepository.findById(id).get());
        return user;
    }


    public boolean atualizarUsuario(Long id, @Valid AtualizacaoUsuario dadoAtualizacao) {
        var usuario = usuarioRepository.getReferenceById(id);

        if(usuario == null || usuarioRepository.existsByEmail(dadoAtualizacao.email())) {
            return false;
        }else{
            usuario.atualizarDados(dadoAtualizacao);
            return true;
        }
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

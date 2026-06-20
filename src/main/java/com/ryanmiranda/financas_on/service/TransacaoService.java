package com.ryanmiranda.financas_on.service;

import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.AtualizarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.CadastrarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.ListarTransicoes;
import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.model.Transacao;
import com.ryanmiranda.financas_on.model.Usuario;
import com.ryanmiranda.financas_on.repository.CategoriaRepository;
import com.ryanmiranda.financas_on.repository.TransacoesRepository;
import com.ryanmiranda.financas_on.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    TransacoesRepository transacoesRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    public boolean cadastroTransicao(CadastrarTransicao cadastrarTransicao) {

        Usuario usuario = usuarioRepository.getReferenceById(cadastrarTransicao.id_usuario());
        Categoria categoria = categoriaRepository.getReferenceById(cadastrarTransicao.id_categoria());

        transacoesRepository.save(new Transacao(cadastrarTransicao, categoria, usuario));
        return true;
    }

    public boolean atualizarTransicao(Long id, AtualizarTransicao atualizarTransicao) {
        var transacao = transacoesRepository.getReferenceById(id);

        if (transacao != null) {
            transacao.atualizarTransicao(atualizarTransicao);
            return true;
        } else {
            return false;
        }

    }

    public boolean deletarTransicao(Long id) {
        transacoesRepository.deleteById(id);
        return true;
    }

    public Page<ListarTransicoes> listarTransicoesPage(Pageable pagina) {
        return transacoesRepository.findAll(pagina).map(ListarTransicoes::new);
    }
}
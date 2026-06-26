package com.ryanmiranda.financas_on.service;

import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.AtualizarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.CadastrarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.DetalhamentoTransacao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.ListarTransicoes;
import com.ryanmiranda.financas_on.model.Categoria;
import com.ryanmiranda.financas_on.model.Tipo;
import com.ryanmiranda.financas_on.model.Transacao;
import com.ryanmiranda.financas_on.model.Usuario;
import com.ryanmiranda.financas_on.repository.CategoriaRepository;
import com.ryanmiranda.financas_on.repository.TransacoesRepository;
import com.ryanmiranda.financas_on.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    @Autowired
    TransacoesRepository transacoesRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    public Transacao cadastroTransicao(CadastrarTransicao cadastrarTransicao) {

        Usuario usuario = usuarioRepository.getReferenceById(cadastrarTransicao.id_usuario());
        Categoria categoria = categoriaRepository.getReferenceById(cadastrarTransicao.id_categoria());

        if(cadastrarTransicao.valor().compareTo(BigDecimal.ZERO) <= 0 || categoria == null || usuario == null || categoria.getUsuario().getId() != usuario.getId()){
            throw new RuntimeException("Erro ao cadastrar transação");
        }
        var transicao = new Transacao(cadastrarTransicao, categoria, usuario);

        transacoesRepository.save(transicao);
        return transicao;
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

    public DetalhamentoTransacao listarTransicoesId(Long id){
        var detalhamento = new DetalhamentoTransacao(transacoesRepository.findById(id).get());
        return detalhamento;
    }

    public Page<ListarTransicoes> listarTransicoesPorMes(int mes, Pageable pageable){
        return transacoesRepository.buscarPorMes(mes, pageable).map(ListarTransicoes::new);
    }

    public Page<ListarTransicoes> listarTransicoesPorAno(int ano, Pageable pageable){
        return  transacoesRepository.buscarPorAno(ano, pageable).map(ListarTransicoes::new);
    }

    public Page<ListarTransicoes> listarTransicoesPorCategoria(String categoria, Pageable pageable){
        return transacoesRepository.buscarPorCategoria(categoria, pageable).map(ListarTransicoes::new);
    }

    public Page<ListarTransicoes> listarPoripo(String tipo, Pageable pag){
        Tipo tipoEscolhido = Tipo.valueOf(tipo.toUpperCase());
        return transacoesRepository.findByTipo(tipoEscolhido, pag).map(ListarTransicoes::new);
    }

    public Page<ListarTransicoes> valorMinimo(double valor, Pageable pageable){
        return transacoesRepository.buscarPorValorMinimo(valor, pageable).map(ListarTransicoes::new);
    }

    public Page<ListarTransicoes> valorMaximo(double valor, Pageable pageable) {
        return transacoesRepository.buscarPorValorMaximo(valor, pageable).map(ListarTransicoes::new);
    }

    public BigDecimal saldoReceitas(){

        Tipo tipoEscolhido = Tipo.valueOf("RECEITA");

        List<Transacao> list = transacoesRepository.findByTipo(tipoEscolhido);

        BigDecimal valorReceita = BigDecimal.ZERO;

        for(Transacao t : list){
            valorReceita = valorReceita.add(t.getValor());
        }

        return valorReceita;

    }
    public BigDecimal saldoDespesas(){

        Tipo tipoEscolhido = Tipo.valueOf("DESPESA");

        List<Transacao> list = transacoesRepository.findByTipo(tipoEscolhido);

        BigDecimal valorDespesa= BigDecimal.ZERO;

        for(Transacao t : list){
            valorDespesa = valorDespesa.add(t.getValor());
        }

        return valorDespesa;

    }

    public BigDecimal saldoDaConta(){
        BigDecimal saldoConta = saldoReceitas().subtract(saldoDespesas());

        return saldoConta;
    }

}
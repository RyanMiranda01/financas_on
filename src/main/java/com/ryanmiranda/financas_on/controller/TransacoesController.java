package com.ryanmiranda.financas_on.controller;

import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.AtualizarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.CadastrarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.DetalhamentoTransacao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.ListarTransicoes;
import com.ryanmiranda.financas_on.service.TransacaoService;
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
@RequestMapping("financason/transacoes")
public class TransacoesController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity cadastrarTransicoes(@RequestBody @Valid CadastrarTransicao cadastrarTransicao, UriComponentsBuilder uriComponentsBuilder) {

        var transacao = transacaoService.cadastroTransicao(cadastrarTransicao);

        var uri = uriComponentsBuilder.path("financason/transacoes/listar/{id}").buildAndExpand(transacao.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoTransacao(transacao));
    }

    @GetMapping("listar")
    public ResponseEntity<Page<ListarTransicoes>> listarTransicoesPage(Pageable pagina) {
        var t = transacaoService.listarTransicoesPage(pagina);
        return ResponseEntity.ok(t);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity transicoesId(@PathVariable Long id) {
        var t = transacaoService.listarTransicoesId(id);
        return ResponseEntity.ok(t);
    }

    @PutMapping("editar/{id}")
    @Transactional
    public ResponseEntity<Boolean> atualizarTrasacoes(@PathVariable Long id, @RequestBody AtualizarTransicao atualizarTransacao) {
        var t = transacaoService.atualizarTransicao(id, atualizarTransacao);
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        var d = transacaoService.deletarTransicao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("listar/mes/{mes}")
    public ResponseEntity<Page<ListarTransicoes>> listarTransicoesMes(@PathVariable int mes, Pageable pageable) {
        var t = transacaoService.listarTransicoesPorMes(mes, pageable);
        return ResponseEntity.ok(t);
    }

    @GetMapping("listar/ano/{ano}")
    public ResponseEntity<Page<ListarTransicoes>> listarTransicoesAno(@PathVariable int ano, Pageable pageable) {
        var t = transacaoService.listarTransicoesPorAno(ano, pageable);
        return ResponseEntity.ok(t);
    }

    @GetMapping("listar/categoria/{categoria}")
    public ResponseEntity<Page<ListarTransicoes>> listarTransicoesCategoria(@PathVariable String categoria, Pageable pageable) {
        var t = transacaoService.listarTransicoesPorCategoria(categoria, pageable);
        return ResponseEntity.ok(t);
    }

    @GetMapping("listar/tipo/{tipo}")
    public ResponseEntity<Page<ListarTransicoes>> listarTransicoesTipo(@PathVariable String tipo, Pageable pageable) {
        var t = transacaoService.listarPoripo(tipo, pageable);
        return ResponseEntity.ok(t);
    }

    @GetMapping("listar/valormin/{valor}")
    public ResponseEntity<Page<ListarTransicoes>> listarValorMinimo(@PathVariable double valor, Pageable pageable) {
        var t = transacaoService.valorMinimo(valor, pageable);
        return ResponseEntity.ok(t);
    }

    @GetMapping("listar/valormax/{valor}")
    public ResponseEntity<Page<ListarTransicoes>> listarValorMaximo(@PathVariable double valor, Pageable pageable) {
        var t = transacaoService.valorMaximo(valor, pageable);
        return ResponseEntity.ok(t);
    }

    @GetMapping("saldo/receita")
    public ResponseEntity<String> totalReceita() {
        var texto = "Valor total da Receita: " + transacaoService.saldoReceitas();
        return ResponseEntity.ok(texto);
    }

    @GetMapping("saldo/despesa")
    public ResponseEntity<String> totalDespesa() {
        var texto = "Valor total da Despesa: " + transacaoService.saldoDespesas();
        return ResponseEntity.ok(texto);
    }

    @GetMapping("saldo/saldofinal")
    public ResponseEntity<String> valorDaConta() {
        var texto = "Valor total da Conta: " + transacaoService.saldoDaConta();
        return ResponseEntity.ok(texto);
    }




}

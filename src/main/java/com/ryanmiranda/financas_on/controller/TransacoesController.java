package com.ryanmiranda.financas_on.controller;

import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.AtualizarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.CadastrarTransicao;
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

@RestController
@RequestMapping("financason/transacoes")
public class TransacoesController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrarTransicoes(@RequestBody @Valid CadastrarTransicao cadastrarTransicao){
        if(transacaoService.cadastroTransicao(cadastrarTransicao)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Transação cadastrada com sucesso!");
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao cadastrar transacao");
        }

    }
    @GetMapping("listar")
    public Page<ListarTransicoes> listarTransicoesPage (Pageable pagina){
        return transacaoService.listarTransicoesPage(pagina);
    }

    @GetMapping("listar/{id}")
    public ListarTransicoes listarTransicoesId(@PathVariable Long id){
        return transacaoService.listarTransicoesId(id);
    }

    @PutMapping("editar/{id}")
    @Transactional
    public boolean atualizarTrasacoes(@PathVariable Long id, @RequestBody AtualizarTransicao atualizarTransicao){
        return transacaoService.atualizarTransicao(id, atualizarTransicao);
    }

    @DeleteMapping("deletar/{id}")
    public boolean deletar(@PathVariable Long id){
        return transacaoService.deletarTransicao(id);
    }

    @GetMapping("listar/mes/{mes}")
    public Page<ListarTransicoes> listarTransicoesMes(@PathVariable int mes, Pageable pageable){
        return  transacaoService.listarTransicoesPorMes(mes, pageable);
    }

    @GetMapping("listar/ano/{ano}")
    public Page<ListarTransicoes> listarTransicoesAno(@PathVariable int ano, Pageable pageable){
        return transacaoService.listarTransicoesPorAno(ano, pageable);
    }

    @GetMapping("listar/categoria/{categoria}")
    public Page<ListarTransicoes> listarTransicoesCategoria(@PathVariable String categoria, Pageable pageable){
        return  transacaoService.listarTransicoesPorCategoria(categoria, pageable);
    }

    @GetMapping("listar/tipo/{tipo}")
    public Page<ListarTransicoes> listarTransicoesTipo(@PathVariable String tipo, Pageable pageable){
        return transacaoService.listarPoripo(tipo, pageable);
    }

    @GetMapping("listar/valormin/{valor}")
    public Page<ListarTransicoes> listarValorMinimo(@PathVariable double valor, Pageable pageable){
        return transacaoService.valorMinimo(valor, pageable);
    }

    @GetMapping("listar/valormax/{valor}")
    public Page<ListarTransicoes> listarValorMaximo(@PathVariable double valor, Pageable pageable){
        return transacaoService.valorMaximo(valor, pageable);
    }

    @GetMapping("saldo/receita")
    public String totalReceita(){
        return "Valor total da Receita: " + transacaoService.saldoReceitas();
    }
    @GetMapping("saldo/despesa")
    public String totalDespesa(){
        return "Valor total da Despesa: " + transacaoService.saldoDespesas();
    }

    @GetMapping("saldo/saldofinal")
    public String valorDaConta(){
        return  "Valor total da Conta: " + transacaoService.saldoDaConta();
    }



}

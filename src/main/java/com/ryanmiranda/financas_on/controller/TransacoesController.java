package com.ryanmiranda.financas_on.controller;

import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.CadastrarTransicao;
import com.ryanmiranda.financas_on.service.TransacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
}

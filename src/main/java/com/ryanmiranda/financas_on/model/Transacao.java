package com.ryanmiranda.financas_on.model;

import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.AtualizarTransicao;
import com.ryanmiranda.financas_on.DTOs.TransicoesDTO.CadastrarTransicao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transicoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private LocalDate data;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Transacao(CadastrarTransicao cadastrarTransicao, Categoria categoria, Usuario usuario) {
        this.descricao = cadastrarTransicao.descricao();
        this.valor = cadastrarTransicao.valor();
        this.tipo = cadastrarTransicao.tipo();
        this.data = LocalDate.now();
        this.categoria = categoria;
        this.usuario = usuario;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void atualizarTransicao(AtualizarTransicao atualizarTransicao) {
        if(atualizarTransicao.descricao() != null){
            this.descricao = atualizarTransicao.descricao();
        }

        if(atualizarTransicao.valor() != null){
            this.valor = atualizarTransicao.valor();
        }
    }
}

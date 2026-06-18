package com.ryanmiranda.financas_on.model;


import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.AtualizacaoUsuario;
import com.ryanmiranda.financas_on.DTOs.UsuarioDTO.CadastroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCriacao;
    @OneToMany
    List<Categoria> categorias;
    @OneToMany
    List<Transacao> transacoes;


    @PrePersist
    public void prePersist() {
        if (dataCriacao == null) {
            dataCriacao = LocalDate.now();
        }
    }


    public Usuario(CadastroUsuario dadosCadastroUsuario) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.senha = dadosCadastroUsuario.senha();
    }

    public void atualizarDados(AtualizacaoUsuario dadoAtualizacao) {
        if(dadoAtualizacao.nome() != null) {
            this.nome = dadoAtualizacao.nome();
        }

        if(dadoAtualizacao.email() != null) {
            this.email = dadoAtualizacao.email();
        }
    }
}

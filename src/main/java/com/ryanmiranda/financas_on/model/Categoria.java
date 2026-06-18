package com.ryanmiranda.financas_on.model;

import com.ryanmiranda.financas_on.DTOs.categoriaDTO.AtualizacaoCategoria;
import com.ryanmiranda.financas_on.DTOs.categoriaDTO.CadastroCategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Categoria(CadastroCategoria cadastroCategoria, Usuario usuario) {
        this.nome = cadastroCategoria.nome();
        this.tipo = cadastroCategoria.tipo();
        this.usuario = usuario;
    }

    public void atualizarCategoria(AtualizacaoCategoria atualizacaoCategoria) {
        if (atualizacaoCategoria.nome() != null) {
            this.nome = atualizacaoCategoria.nome();
        }
        if (atualizacaoCategoria.tipo() != null) {
            this.tipo = atualizacaoCategoria.tipo();
        }
    }
}

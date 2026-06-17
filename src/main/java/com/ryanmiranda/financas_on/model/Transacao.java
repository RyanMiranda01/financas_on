package com.ryanmiranda.financas_on.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transacao")
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
    @PrePersist
    public void prePersist() {
        if (data == null) {
            data = LocalDate.now();
        }
    }
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

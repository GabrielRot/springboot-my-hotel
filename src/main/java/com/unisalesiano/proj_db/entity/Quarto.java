package com.unisalesiano.proj_db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quarto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quarto")
    private Long idQuarto;

    @ManyToOne
    @JoinColumn(name = "id_tipo_quarto", referencedColumnName = "id_tipo_quarto")
    private TipoQuarto tipoQuarto;

    @Column(name  = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "observacoes", columnDefinition = "LONGTEXT")
    private String observacoes;

}

package com.unisalesiano.proj_db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_quarto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_quarto")
    private Long idTipoQuarto;

    @Column(name = "descricao")
    private String descricao;

}

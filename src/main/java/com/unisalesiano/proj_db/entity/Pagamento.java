package com.unisalesiano.proj_db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long idPagamento;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private Reserva reserva;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "valor_desconto")
    private Double valorDesconto;

    @Column(name = "juros")
    private Double juros;

    @Column(name = "valor_total")
    private Double valorTotal;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_encerramento")
    private LocalDate dataEncerramento;

    @Column(name = "forma_pagto")
    private String formaPagto;
}

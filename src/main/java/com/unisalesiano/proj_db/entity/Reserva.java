package com.unisalesiano.proj_db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_quarto", nullable = false)
    private Quarto quarto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_inicial")
    private LocalDate dataInicial;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_final")
    private LocalDate dataFinal;

    @Column(name = "status_reserva", columnDefinition = "CHAR", precision = 1)
    private String statusReserva;

}

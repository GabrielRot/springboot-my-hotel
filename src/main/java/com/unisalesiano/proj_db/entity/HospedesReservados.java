package com.unisalesiano.proj_db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hospedes_reservados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospedesReservados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospede_reservado")
    private Long idHospedeReservado;

    @ManyToOne
    @JoinColumn(name = "id_hospede", referencedColumnName = "id_hospede")
    private Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private Reserva reserva;

}

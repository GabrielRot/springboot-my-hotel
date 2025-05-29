package com.unisalesiano.proj_db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "servicos_realizados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicosRealizados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serv_realizado")
    private Long idServRealizado;

    @ManyToOne
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private Reserva reserva;

    @Column(name = "data_realizado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRealizado;

    @Column(name = "observacoes", columnDefinition = "LONGTEXT")
    private String observacoes;
}

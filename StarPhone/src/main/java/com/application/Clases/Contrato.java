package com.application.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Contrato", indexes = {
        @Index(
                name = "idx_usuario",
                columnList = "usuario_id",
                unique =false
        )
})
public class Contrato extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "ID")
    private UUID id;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "usuario_id")
    @NotNull
    private User usuario;


    @NotEmpty
    @Column(name = "Fecha_Inicio")
    private LocalDate FechaInicio;

    @NotEmpty
    @Column(name = "Fecha_Fin")
    private LocalDate FechaFin;

    @NotEmpty
    @Column(name = "Estado")
    private String Estado;


   @OneToMany(mappedBy = "contrato")
    private List<LineaMovil> lineamovil;



   @OneToMany(mappedBy = "contrato")
    private List<Factura> Facturas;




    @OneToMany(mappedBy = "contrato")
    private List<ConsultasReclamaciones> ConsultasReclamaciones;


    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }


    public List<LineaMovil> getLineamovil() {
        return lineamovil;
    }

    public void setLineamovil(List<LineaMovil> lineamovil) {
        this.lineamovil = lineamovil;
    }

    public List<Factura> getFacturas() {
        return Facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        Facturas = facturas;
    }

    public List<com.application.Clases.ConsultasReclamaciones> getConsultasReclamaciones() {
        return ConsultasReclamaciones;
    }

    public void setConsultasReclamaciones(List<com.application.Clases.ConsultasReclamaciones> consultasReclamaciones) {
        ConsultasReclamaciones = consultasReclamaciones;
    }

}


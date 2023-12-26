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
@Table(name = "ConsultasReclamaciones")
public class ConsultasReclamaciones extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "ID")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LineaMovil_ID")
    private MobileLine lineamovil;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contrato_id")
    private Contract contrato;

    @NotEmpty
    @Column(name = "Descripcion")
    private String Descripcion;
    // Estado
    @NotEmpty
    @Column(name = "Estado")
    private String Estado;
    // Fecha Creacion
    @NotEmpty

    @Column(name = "Fecha_Creacion")
    private LocalDate FechaCreacion;

    @NotEmpty
    @Column(name = "Fecha_Resolucion")
    private LocalDate FechaResolucion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "RespuestaReclamacion_ID")
    private List<RespuestaReclamacion> respuestasReclamaciones;

    public List<RespuestaReclamacion> getRespuestasReclamaciones() {
        return respuestasReclamaciones;
    }

    public void setRespuestasReclamaciones(List<RespuestaReclamacion> respuestasReclamaciones) {
        this.respuestasReclamaciones = respuestasReclamaciones;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MobileLine getLineamovil() {
        return lineamovil;
    }

    public void setLineamovil(MobileLine lineamovil) {
        this.lineamovil = lineamovil;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaResolucion() {
        return FechaResolucion;
    }

    public void setFechaResolucion(LocalDate fechaResolucion) {
        FechaResolucion = fechaResolucion;
    }

}

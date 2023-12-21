package ProyectoFinal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Contrato")
public class Contrato extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name="ID")
    private UUID id;



    @NotEmpty
    @Column(name = "Fecha_Inicio")
    private LocalDate FechaInicio;

    @NotEmpty
    @Column(name = "Fecha_Fin")
    private LocalDate FechaFin;

    @NotEmpty
    @Column(name = "Estado")
    private String Estado;




    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "LineaMovil_ID")
    private List<LineaMovil> lineamovil;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Factura_ID")
    private List<Factura> Facturas;




    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ConsultasReclamaciones_ID")
    private List<ConsultasReclamaciones> ConsultasReclamaciones;


    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
    public List<ProyectoFinal.ConsultasReclamaciones> getConsultasReclamaciones() {
        return ConsultasReclamaciones;
    }

    public void setConsultasReclamaciones(List<ProyectoFinal.ConsultasReclamaciones> consultasReclamaciones) {
        ConsultasReclamaciones = consultasReclamaciones;
    }

}


package com.application.Clases;

import com.vaadin.flow.component.template.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Factura", indexes = {
        @Index(
                name = "idx_contrato",
                columnList = "contrato_id",
                unique = false

        )
}
)

public class Factura extends AbstractEntity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "ID")
    private UUID id;



    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;


    @NotEmpty
    @Column(name = "Fecha_Inicio")
    private LocalDate FechaInicio;

    @NotEmpty
    @Column(name = "Fecha_Fin")
    private LocalDate FechaFin;

    @NotEmpty
    @Column(name = "Importe")
    private Double Importe;

    @NotEmpty
    @Column(name = "Estado_Pago")
    private String EstadoPago;


    //Guardar un pdf
    @NotEmpty
    @Column(name = "PDF_Factura", columnDefinition = "BLOB")
    @Lob
    private byte[] PDFFactura;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
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

    public Double getImporte() {
        return Importe;
    }

    public void setImporte(Double importe) {
        Importe = importe;
    }

    public String getEstadoPago() {
        return EstadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        EstadoPago = estadoPago;
    }

    public byte[] getPDFFactura() {
        return PDFFactura;
    }

    public void setPDFFactura(byte[] PDFFactura) {
        this.PDFFactura = PDFFactura;
    }



}

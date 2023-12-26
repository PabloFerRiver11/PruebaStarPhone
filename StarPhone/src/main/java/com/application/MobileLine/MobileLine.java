package com.application.MobileLine;

import com.application.General.AbstractEntity;
import com.application.Contract.Entities.Contract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mobileline", indexes = {
        @Index(name = "idx_contract", columnList = "contract_id", unique = false)
})
public class MobileLine extends AbstractEntity {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotEmpty
    @Column(name = "serviceType", nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @NotEmpty
    @Column(name = "monthlyPrice", nullable = false)
    private Double monthlyPrice;

    @NotEmpty
    @Column(name = "phoneNumber", nullable = false)
    private int phoneNumber;

    @NotEmpty
    @Column(name = "phoneModel", nullable = false)
    private String phoneModel;

    @Column(name = "roaming", nullable = false)
    private boolean roaming;

    @Column(name = "shareData", nullable = false)
    private boolean shareData;

    @Column(name = "Volumen_Mensual", nullable = false)
    private Double Volumen_Mensual;

    @Column(name = "totalCalls", nullable = false)
    private int totalCalls;

    @Column(name = "SMS", nullable = false)
    private int SMS;

    @Column(name = "Datos", nullable = false)
    private Double Datos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "linea_movil_id")
    private List<NumerosBloqueados> numerosBloqueados;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Double getTarifa() {
        return Tarifa;
    }

    public void setTarifa(Double tarifa) {
        Tarifa = tarifa;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getNombre_Telefono() {
        return Nombre_Telefono;
    }

    public void setNombre_Telefono(String nombre_Telefono) {
        Nombre_Telefono = nombre_Telefono;
    }

    public boolean isRoaming() {
        return Roaming;
    }

    public void setRoaming(boolean roaming) {
        Roaming = roaming;
    }

    public boolean isCompartir_Datos() {
        return Compartir_Datos;
    }

    public void setCompartir_Datos(boolean compartir_Datos) {
        Compartir_Datos = compartir_Datos;
    }

    public Double getVolumen_Mensual() {
        return Volumen_Mensual;
    }

    public void setVolumen_Mensual(Double volumen_Mensual) {
        Volumen_Mensual = volumen_Mensual;
    }

    public int getLlamadas() {
        return Llamadas;
    }

    public void setLlamadas(int llamadas) {
        Llamadas = llamadas;
    }

    public int getSMS() {
        return SMS;
    }

    public void setSMS(int SMS) {
        this.SMS = SMS;
    }

    public Double getDatos() {
        return Datos;
    }

    public void setDatos(Double datos) {
        Datos = datos;
    }

    public ServiceType getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(ServiceType tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

}

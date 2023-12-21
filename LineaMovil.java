package ProyectoFinal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "LineaMovil")
public class LineaMovil extends AbstractEntity {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name="ID")
    private UUID id;

    @NotEmpty
    @Column(name = "Nombre", nullable = false)
    private String Nombre;

    @NotEmpty
    @Column(name = "Apellido", nullable = false)
    private String Apellido;



    @NotEmpty
    @Column(name = "Tipo_Servicio", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoServicio tipoServicio;

    @NotEmpty
    @Column(name = "Tarifa", nullable = false)
    private Double Tarifa;

    @NotEmpty
    @Column(name = "Teléfono", nullable = false)
    private int Telefono;

    @NotEmpty
    @Column(name = "Nombre_Teléfono", nullable = false)
    private String Nombre_Telefono;

    @Column(name = "Roaming", nullable = false)
    private boolean Roaming;

    @Column(name = "Compartir_Datos", nullable = false)
    private boolean Compartir_Datos;

    @Column(name = "Volumen_Mensual", nullable = false)
    private Double Volumen_Mensual;

    @Column(name = "Llamadas", nullable = false)
    private int Llamadas;

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

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

















}

package ProyectoFinal;

import ProyectoFinal.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

   enum Rol {
    Cliente, Marketing, Finanzas, Atencion_Cliente
    }



@Entity
@Table(name = "User")
public class User extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name="ID")
    private UUID id;


    @NotEmpty
    @Column(name="DNI",unique = true)
    private String DNI;

    @NotEmpty
    @Column(name = "Nombre")
    private String Nombre;

    @NotEmpty
    @Column(name = "Apellido")
    private String Apellido;

    @NotEmpty
    @Column(name = "Ciudad")
    private String Ciudad;

    @NotEmpty
    @Column(name = "Pais")
    private String Pais;

    @NotEmpty
    @Column(name = "Fecha_Nacimiento")
    private LocalDate FechaNacimiento;

    @NotEmpty
    @Column(name = "Telefono")
    private int Telefono;

    @NotEmpty
    @Column(name = "Sexo")
    private String Sexo;

    @NotEmpty
    @Column(name = "Correo_electronico", unique = true)
    private String CorreoElectronico;

    @NotEmpty
    @Column(name = "Contrasenna")
    private String Contrasenna;


    @NotEmpty
    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol Rol;



    //Contratos
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Contrato_ID")
    private List<Contrato> Contratos;


    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public String getContrasenna() {
        return Contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        Contrasenna = contrasenna;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol rol) {
        Rol = rol;
    }

    public List<Contrato> getContratos() {
        return Contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        Contratos = contratos;
    }

}





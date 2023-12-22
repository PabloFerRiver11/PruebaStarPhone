package com.application.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

enum Rol {
    Cliente, Marketing, Finanzas, Atencion_Cliente, ADMIN
}



@Entity
//Hacer @Table llamada Usuario y que contenga index
@Table(name= "user",
        indexes = {
                @Index(
                        name = "idx_correo_electronico",
                        columnList = "Correo_electronico",
                        unique =true
                )
        }

)
public class User extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "ID")
    private UUID id;


    @NotNull(message = "El DNI no puede estar vacío, por favor introduzca su DNI")
    @Size(min = 9, max = 9, message = "Introduca de nuevo su dni")
    @Column(name = "DNI", unique = true)
    private String DNI;

    @NotNull(message = "El nombre no puede estar vacío, por favor introduzca su nombre")
    @Column(name = "Nombre")
    private String Nombre;

    @NotNull(message = "El apellido no puede estar vacío, por favor introduzca su apellido")
    @Column(name = "Apellido")
    private String Apellido;

    @NotNull(message = "La ciudad no puede estar vacía, por favor introduzca su ciudad")
    @Column(name = "Ciudad")
    private String Ciudad;

    @NotNull(message = "El país no puede estar vacío, por favor introduzca su país")
    @Column(name = "Pais")
    private String Pais;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía, por favor introduzca su fecha de nacimiento")
    @Column(name = "Fecha_Nacimiento")
    private LocalDate FechaNacimiento;

    @NotNull(message = "El teléfono no puede estar vacío, por favor introduzca su teléfono")
    @Column(name = "Telefono")
    private int Telefono;

    @NotNull(message = "El género no puede estar vacío, por favor introduzca su género")
    @Column(name = "Sexo")
    private String Sexo;

    @NotNull(message = "El correo electrónico no puede estar vacío, por favor introduzca su correo electrónico")
    @Column(name = "Correo_electronico", unique = true)
    private String email;

    @NotNull(message = "La contraseña no puede estar vacía, por favor introduzca su contraseña")
    @Column(name = "Contrasenna")
    private String Contrasenna;


    @NotNull(message = "El rol no puede estar vacío, por favor introduzca su rol")
    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol Rol;


    //Contratos
    @OneToMany(mappedBy = "usuario")
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
        return email;
    }

    public void setCorreoElectronico(String correoElectronico) {
        email = correoElectronico;
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





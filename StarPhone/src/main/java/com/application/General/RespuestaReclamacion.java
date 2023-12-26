package com.application.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "RespuestaReclamacion")
public class RespuestaReclamacion extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "ID")
    private UUID id;


    @NotEmpty
    @Column(name = "Descripcion")
    private String Descripcion;


    @NotEmpty
    @Column(name = "Fecha_Creacion")
    private LocalDate FechaCreacion;


    //Trabajador que responde, es decir, el que tiene el rol de Atencion_Cliente
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }


}

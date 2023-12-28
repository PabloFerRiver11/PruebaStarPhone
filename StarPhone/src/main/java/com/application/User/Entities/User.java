package com.application.User.Entities;

import com.application.General.AbstractEntity;
import com.application.Contract.Entities.Contract;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Entity

@Table(name = "user", indexes = {
        @Index(name = "idx_email", columnList = "email", unique = true)
}

)
public class User implements UserDetails {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id")
    private UUID id;

    @NotNull(message = "Por favor, introduzca su DNI")
    @Size(min = 9, max = 9, message = "Introduca de nuevo su dni")
    @Column(name = "DNI", unique = true)
    private String DNI;

    @NotNull(message = "Por favor, introduzca su nombre")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Por favor,introduzca su apellido")
    @Column(name = "surname")
    private String surname;

    @NotNull(message = "Por favor, introduzca su Username")
    @Column(name = "username", unique = true)
    private String username;

    @NotNull(message = "Por favor, introduzca su ciudad")
    @Column(name = "city")
    private String city;

    @NotNull(message = "Por favor, introduzca su país")
    @Column(name = "country")
    private String country;

    @NotNull(message = "Por favor, introduzca su fecha de nacimiento")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @NotNull(message = "Por favor, introduzca su teléfono")
    @Column(name = "phoneNumber")
    private int phoneNumber;

    @NotNull(message = "Por favor, introduzca su género")
    @Column(name = "gender")
    private String gender;

    @NotNull(message = "Por favor, introduzca su email")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "Por favor, introduzca su contraseña")
    @Column(name = "password")
    private String password;

    @Column(name = "activate")
    private boolean activate;

    @Column(name = "activateCode")
    private int activateCode;

    @Column(name = "registerDate")
    private LocalDate registerDate;

    // Roles
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Rol> roles = new HashSet<>();

    // Contratos
    @OneToMany(mappedBy = "user")
    private List<Contract> contracts;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public int getActivateCode() {
        return this.activateCode;
    }

    public void setActivateCode(int activateCode) {
        this.activateCode = activateCode;
    }

    public LocalDate getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRol(Set<Rol> roles) {
        this.roles = roles;
    }
    public void setSingleRol(Rol rol) {
        this.roles.add(rol);
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }




    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User other)) {
            return false; // null or other class
        }

        if (id != null) {
            return id.equals(other.id);
        }
        return super.equals(other);
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.activate;
    }

}
package com.test.apicumpleanos.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @NotBlank(message = "Nombre es requerido")
    private String nombre ;

    @NotBlank(message = "apellido es requerido")
    private String apellido ;

    @NotNull
    @Temporal(TemporalType.DATE)
 //   @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
    private int edad;

    @Column(length = 3000)
    private String mensaje;

    public Persona() {
    }

    public Persona(@NotBlank(message = "Nombre es requerido") String nombre, @NotBlank(message = "apellido es requerido") String apellido, @NotNull Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

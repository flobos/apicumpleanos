package com.test.apicumpleanos.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @NotBlank(message = "Nombre es requerido")
    private String nombre ;
    @NotBlank(message = "apellido es requerido")
    private String apellido ;
    @NotBlank(message = "fechaNacimiento es requerido")
    private Date fechaNacimiento;
    private int edad;
    private String mesaje;

}

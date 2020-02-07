package com.test.apicumpleanos.controller;

import com.test.apicumpleanos.domain.Persona;
import com.test.apicumpleanos.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("")
    public ResponseEntity<?> agregaPersona(@Valid @RequestBody Persona persona){

        Persona nuevaPersona = new Persona();

        try {
             nuevaPersona = personaService.guardaPersona(persona);

        }catch (Exception ex){
            return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Persona>(nuevaPersona, HttpStatus.CREATED);

    }
}

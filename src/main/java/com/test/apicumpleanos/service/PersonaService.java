package com.test.apicumpleanos.service;

import com.test.apicumpleanos.domain.Persona;
import com.test.apicumpleanos.domain.jackson.Poema;
import com.test.apicumpleanos.repository.PersonaRepository;
import com.test.apicumpleanos.util.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PersonaService {

    static final String URI_POEMS = "https://www.poemist.com/api/v1/randompoems";

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private Utiles utiles;

    public Persona guardaPersona(Persona persona){

        int edad = utiles.calculaEdad(persona.getFechaNacimiento());
        persona.setEdad(edad);


        if (utiles.esCumpleanos(persona.getFechaNacimiento())) {
            for (final Poema p : obtienePoema()) {
                persona.setMensaje(p.getContent());
            }

        }
        return personaRepository.save(persona);

    }

    public List<Persona> todasPersona(){


        return personaRepository.findAll();

    }



    private Poema[] obtienePoema()
    {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(URI_POEMS, Poema[].class);

    }





}

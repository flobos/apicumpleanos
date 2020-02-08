package com.test.apicumpleanos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.apicumpleanos.domain.Persona;
import com.test.apicumpleanos.service.PersonaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonaController.class)
public class PersonaControllerTest {


    @Autowired
    MockMvc mockmvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PersonaService personaService;

    @Test
    public void retornaEsCreadoTest() throws Exception {

        Date hoy = new Date();
        Persona persona = new Persona();
        persona.setNombre("Fernando");
        persona.setApellido("Lobos");
        persona.setFechaNacimiento(hoy);

        List<Persona> personas = Arrays.asList(persona);

        when(personaService.todasPersona()).thenReturn(personas);


        mockmvc.perform(post("/api/persona")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isCreated());

    }

    @Test
    public void retornaBadRequetTest() throws Exception {

        Date hoy = new Date();
        Persona persona = new Persona();


        List<Persona> personas = Arrays.asList(persona);

        when(personaService.todasPersona()).thenReturn(personas);


        mockmvc.perform(post("/api/persona")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isBadRequest());

    }




}




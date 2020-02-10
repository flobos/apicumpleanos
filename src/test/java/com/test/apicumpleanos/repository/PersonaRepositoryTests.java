package com.test.apicumpleanos.repository;

import com.test.apicumpleanos.domain.Persona;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class PersonaRepositoryTests {

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    public void testGuardaPersona() {

        Date hoy = new Date();
        Persona persona = new Persona("Fernando", "Lobos", hoy );
        personaRepository.save(persona);
        Persona personaTest = personaRepository.findByNombre("Fernando");
        assertNotNull(persona);
        assertEquals(personaTest.getNombre(), persona.getNombre());
        assertEquals(personaTest.getApellido(), persona.getApellido());
        assertEquals(personaTest.getFechaNacimiento(), persona.getFechaNacimiento());
    }
    @Test
    public void testBorraPersona() {

        Date hoy = new Date();
        Persona persona = new Persona("Fernando", "Lobos", hoy );
        personaRepository.save(persona);
        personaRepository.delete(persona);
        Persona personaTest = personaRepository.findByNombre("Fernando");
        assertNull(personaTest);
    }

    @Test
    public void buscaTodasPersona() {
        Date hoy = new Date();
        Persona persona = new Persona("Fernando", "Lobos", hoy );
        personaRepository.save(persona);
        assertNotNull(personaRepository.findAll());
    }

    @Test
    public void borraPorIdTest() {
        Date hoy = new Date();
        Persona persona = new Persona("Fernando", "Lobos", hoy );
        Persona per = personaRepository.save(persona);
        personaRepository.deleteById(per.getId());
        Persona personaTest = personaRepository.findByNombre("Fernando");
        assertNull(personaTest);
    }







}

package com.test.apicumpleanos.repository;

import com.test.apicumpleanos.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}

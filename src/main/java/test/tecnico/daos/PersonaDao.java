package test.tecnico.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import test.tecnico.modelos.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long> {}

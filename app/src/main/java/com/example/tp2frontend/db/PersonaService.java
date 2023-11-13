package com.example.tp2frontend.db;

import java.util.List;

public class PersonaService {
    private PersonaDao personaDao;

    public PersonaService(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public List<Persona> getPersonas() {
        return personaDao.getPersonas();
    }

    public Persona getPersonaById(int id) {
        return personaDao.getPersonaById(id);
    }

    public void addPersona(Persona persona) {
        personaDao.insert(persona);
    }
}

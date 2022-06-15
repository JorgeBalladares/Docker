package com.example.EJ2.Profesor.application.Services;


import com.example.EJ2.person.Domain.Entities.Person;
import com.example.EJ2.Profesor.infraestructure.dto.InPuts.ProfesorInputDTO;
import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutFullDTO;

public interface ProfesorService {

    public ProfesorOutFullDTO addProfesor(ProfesorInputDTO inputDTO) throws Exception;
    public Object findIdProf (String id, String outputType) throws Exception;
    public void CheckRoll (Person person) throws Exception;
    }

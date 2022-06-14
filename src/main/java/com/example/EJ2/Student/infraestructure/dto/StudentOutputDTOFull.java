package com.example.EJ2.Student.infraestructure.dto;


import com.example.EJ2.Persona.Infraestructure.dto.Inputs.PersonaInputDTO;
import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutFullDTO;
import com.example.EJ2.Signature.infraestructure.dto.Outputs.OutSimpleSingatureDTO;
import lombok.Data;

import java.util.List;


@Data

public class StudentOutputDTOFull  {

    private String id_student;
    private PersonaInputDTO persona;
    private int num_hours_week;
    private ProfesorOutFullDTO profesor;
    private String branch;
    private List<OutSimpleSingatureDTO>signatures;

}

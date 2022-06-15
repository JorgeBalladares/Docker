package com.example.EJ2.person.Application.UserCases;


import com.example.EJ2.Exception.Customizer.UnprocesableException;
import com.example.EJ2.person.Application.Services.PersonaService;
import com.example.EJ2.person.Domain.Entities.Person;
import com.example.EJ2.person.Domain.repositories.PersonaRepository;
import com.example.EJ2.person.Infraestructure.dto.Outputs.PersonProfDTOOut;
import com.example.EJ2.person.Infraestructure.dto.Outputs.PersonStudODTOOut;
import com.example.EJ2.person.Infraestructure.dto.Inputs.PersonaInputDTO;
import com.example.EJ2.person.Infraestructure.dto.Outputs.PersonaOutSimpleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    List<Person> listaPerson;


    public PersonaInputDTO addPersona(PersonaInputDTO persona) throws Exception {
        Person p = modelMapper.map(persona, Person.class);
        if (persona.getUsuario() == null || persona.getPassword() == null || persona.getName() == null || persona.getCompany_email() == null
                || persona.getPersonal_email() == null || persona.getCity() == null || persona.getCreated_date() == null) {
            throw new Exception("Faltan campos imprescindibles");
        }
        if (persona.getUsuario().length() > 10) {
            throw new UnprocesableException("Valores no válidos");
        } else personaRepositorio.save(p);
        return modelMapper.map(p, PersonaInputDTO.class);
    }


    public Object getByID(int id) throws Exception {
        Optional<Person> person = personaRepositorio.findById(id);
        Person p = modelMapper.map(person, Person.class);
        if (person.isPresent()) {
            if (p.getProfesor() == null && p.getStudent() == null) {
                return modelMapper.map(person, PersonaInputDTO.class);
            } else {
                if (p.getStudent() != null) {
                    return modelMapper.map(person, PersonStudODTOOut.class);
                }
            }
        }
        return modelMapper.map(person, PersonProfDTOOut.class);
    }


    public List<PersonaInputDTO> getPersonByName(String name) {
        listaPerson = personaRepositorio.findByName(name);
        return listaPerson.stream()
                .map(Persona -> modelMapper.map(Persona, PersonaInputDTO.class))
                .collect(Collectors.toList());
    }

    public PersonaOutSimpleDTO updPerson(int id, PersonaInputDTO personaInputDTO) throws Exception {
        Optional<Person> persona = personaRepositorio.findById(id);
        Person persona1 = modelMapper.map(persona, Person.class);
        Person person = modelMapper.map(personaInputDTO, Person.class);
        if(!persona.isPresent()){
            throw new Exception("No existe una persona con el id buscado");
        }
        else {
            if(person.getId()==persona1.getId()) {
                personaRepositorio.save(person);
                return modelMapper.map(person, PersonaOutSimpleDTO.class);
            }
            else {
                throw new Exception("id no asignado, no se puede actualizar");
            }
        }
    }


    public List<PersonaInputDTO> getTotalList() throws Exception {
        List<Person> lista = personaRepositorio.findAll();

        if (lista != null) {
            return lista.stream()
                    .map(Persona -> modelMapper.map(Persona, PersonaInputDTO.class))
                    .collect(Collectors.toList());
        }
        throw new Exception("Lista vacía");
    }

    public void deleteObj(int id) throws Exception {
        personaRepositorio.deleteById(id);
    }

    public void CheckRoll(Person person) throws Exception {
        if (person.getProfesor() != null) {
            throw new Exception("Persona asignada a un profesor");
        } else if (person.getStudent() != null) {
            throw new Exception("Persona asignada a un estudiante");
        } else {
            System.out.println("añadidos");
        }
    }

}

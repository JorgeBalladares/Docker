package com.example.EJ2.person.Infraestructure.controller;


import com.example.EJ2.person.Application.UserCases.PersonaServiceImpl;
import com.example.EJ2.person.Infraestructure.dto.Inputs.PersonaInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AddPersonControl {
    @Autowired
    private PersonaServiceImpl servicio;
    @Autowired
    private ModelMapper model;

    @PostMapping(value = "/addPersona")
    //Al haber etiqueta Valid recogera el error 400 del HandlerControlAdvice y si se comenta esta clase genera error 500
    //ya que no sabe que error recoger y envía el genérico. Es algo raro de entender
    public ResponseEntity<PersonaInputDTO> addPerson(@RequestBody @Valid PersonaInputDTO p1Dto) throws Exception {
        //try {
        PersonaInputDTO p = servicio.addPersona(p1Dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(p);
        //}catch (Exception e) {
        // return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        //}
    }


    @CrossOrigin (origins="https://cdpn.io")
    @PostMapping (value = "/addperson")
    public ResponseEntity<PersonaInputDTO> createPersonFrontal (@RequestBody @Valid PersonaInputDTO p1Dto) throws Exception {
        //try {
        PersonaInputDTO p = servicio.addPersona(p1Dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(p);
        //}catch (Exception e) {
        // return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        //}
    }



}



package com.example.EJ2.person.Infraestructure.controller;


import com.example.EJ2.person.Application.UserCases.PersonaServiceImpl;
import com.example.EJ2.person.Infraestructure.dto.Inputs.PersonaInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerGetListAll {

    @Autowired
    private PersonaServiceImpl servicio;
    @Autowired
    private ModelMapper model;

    @GetMapping(value = "/allDisplay")
    public ResponseEntity<List<PersonaInputDTO>> getAllData() throws Exception {
        if (servicio.getTotalList().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(servicio.getTotalList());
        }
         else {
             return ResponseEntity.status(HttpStatus.OK).body(servicio.getTotalList());
        }
    }

    @CrossOrigin (origins="https://cdpn.io")
    @GetMapping(value = "/getall")
    public ResponseEntity<List<PersonaInputDTO>> getall() throws Exception {
        if (servicio.getTotalList().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(servicio.getTotalList());
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.getTotalList());
        }
    }


}

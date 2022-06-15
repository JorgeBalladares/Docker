package com.example.EJ2.person.Domain.repositories;


import com.example.EJ2.person.Domain.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Person,Integer> {
    List<Person> findByName(String name);
}

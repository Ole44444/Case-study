package com.example.brutus.Repositories;

import com.example.brutus.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByfirstName(String firstName);
    List<Person> findAll();
}

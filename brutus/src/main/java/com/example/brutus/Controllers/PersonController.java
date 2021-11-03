package com.example.brutus.Controllers;

import com.example.brutus.Entities.Person;
import com.example.brutus.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    String getIndex(Model model){
        List<Person> persons = personRepository.findAll();
        System.out.println(persons.size());
        model.addAttribute("personList", persons);
        return "index";
    }
}

package com.example.taskforreview.controller;

import com.example.taskforreview.dto.PersonDTO;
import com.example.taskforreview.facade.PersonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonFacade personFacade;

    @Autowired
    public PersonController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @GetMapping
    public List<PersonDTO> getPersons() {
        return personFacade.getPersons();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return personFacade.getPerson(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        personFacade.deletePerson(id);
    }

    @PostMapping
    public void addPerson(@RequestBody PersonDTO personDTO) {
        personFacade.addPerson(personDTO);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") int id,
                             @RequestBody(required = false) PersonDTO personDTO) {
        personDTO.setId(id);
        personFacade.updatePerson(personDTO);
    }
}

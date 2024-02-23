package com.springboot.apirest.spring.controller;

import com.springboot.apirest.spring.controller.dto.PersonDTO;
import com.springboot.apirest.spring.model.Person;
import com.springboot.apirest.spring.service.PersonService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private final PersonService personService;

    @PostMapping("/save")
    public void createPerson(@RequestBody Person person){
        personService.createPerson(person);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> findPersonById(@PathVariable long id){
        Optional<Person> optionalPerson = personService.findById(id);
        if(optionalPerson.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Person person = optionalPerson.get();
        PersonDTO personDTO = PersonDTO.builder().id(person.getId()).name(person.getName()).lastName(person.getLastName()).email(person.getEmail()).build();
        return ResponseEntity.ok(personDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        List<PersonDTO> personDTOList = personService.findAllPerson().stream().map(person -> PersonDTO.builder().id(person.getId()).name(person.getName()).lastName(person.getLastName()).email(person.getEmail()).build()).toList();
        return ResponseEntity.ok(personDTOList);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(personService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        personService.deletePerson(id);
        return ResponseEntity.ok("person has been deleted");

    }

}

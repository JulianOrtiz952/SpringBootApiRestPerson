package com.springboot.apirest.spring.service;

import com.springboot.apirest.spring.model.Person;
import com.springboot.apirest.spring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;

    public void createPerson(Person person){
        personRepository.save(person);
    }

    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }

    public List<Person> findAllPerson(){
        return personRepository.findAll();
    };

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

}

package org.example.controller;

import org.example.model.Pet;
import org.example.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    private static final String ENDPOINT = "uniara/api/v1/pet";

    @Autowired
    private PetService petService;

    @PostMapping(ENDPOINT)
    public Pet save(@RequestBody Pet pet){
        return petService.save(pet);
    }

    @GetMapping(ENDPOINT)
    public List<Pet> findAll(){
        return petService.findAll();
    }
}
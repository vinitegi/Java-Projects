package org.example.service;

import org.example.model.Pet;
import org.example.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet save(Pet pet){
        return petRepository.save(pet);
    }

    public List<Pet> findAll(){
        return petRepository.findAll();
    }
}
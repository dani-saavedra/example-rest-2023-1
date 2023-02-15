package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorld {
    //POSTMAN -> INSTALAR

    @GetMapping(path = "/hola")
    public String saludar() {
        System.out.println("Me pidio saludar");
        return "Hola mundo";
    }

    List<String> pets = new ArrayList<>();

    @GetMapping(path = "/pet/{idPet}")
    public String getPet(@PathVariable int idPet) {
        pets.add("Celeste");//temporal
        pets.add("Lexa");//temporal
        return pets.get(idPet);
    }

    @DeleteMapping(path = "/pet/{pet}")
    public String deletePet(@PathVariable int pet) {
        try {
            pets.remove(pet);
            return "TODO BIEN, LO ELIMINE";
        } catch (IndexOutOfBoundsException e) {
            return "esta tratando de eliminar una mascota";
        }

    }
}

package com.example.demo.controller;


import com.example.demo.controller.dto.PetDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController {

    static List<String> pets = new ArrayList<>();
    static List<PetDTO> pets2 = new ArrayList<>();

    public PetController(List<String> pets) {

    }

    @GetMapping("/petsOld")
    public List<String> searchPet(@RequestParam String nombre,
                                  @RequestParam int maximo) {
        pets.add("celeste");//temporal
        pets.add("celeste Sofia");//temporal
        pets.add("Lexa");//temporal
        pets.add("Chuwy");
        pets.add("cele");
        List<String> resultado = new ArrayList<>();
        for (String pet : pets) {
            if (pet.contains(nombre) && resultado.size() < maximo) {
                resultado.add(pet);
            }
        }
        return resultado;
    }

    //NO HAGAN ESTO
    @GetMapping("/pets/{nombre}/{maximo}")
    public List<String> searchPetError(@PathVariable String nombre,
                                       @PathVariable int maximo) {
        pets.add("celeste");//temporal
        pets.add("celeste Sofia");//temporal
        pets.add("Lexa");//temporal
        pets.add("Chuwy");
        pets.add("cele");
        List<String> resultado = new ArrayList<>();
        for (String pet : pets) {
            if (pet.contains(nombre) && resultado.size() < maximo) {
                resultado.add(pet);
            }
        }
        return resultado;
    }


    @GetMapping(path = "/pet/{idPet}")
    public String getPet(@PathVariable int idPet) {
        return pets.get(idPet);
    }

    @DeleteMapping(path = "/pet/{pet}")
    public String deletePet(@PathVariable int pet) {
        if (pets.isEmpty()) {
            pets.add("celeste");//temporal
            pets.add("celeste Sofia");//temporal
            pets.add("Lexa");//temporal
            pets.add("Chuwy");
            pets.add("cele");
        }
        try {
            pets.remove(pet);
            return "TODO BIEN, LO ELIMINE";
        } catch (IndexOutOfBoundsException e) {
            return "esta tratando de eliminar una mascota que no existe";
        }
    }

    @PostMapping(path = "/pet")
    public void savePet(@RequestBody PetDTO pet) {
        pets2.add(pet);
    }

    @GetMapping(path = "/pets/all")
    public List<PetDTO> getAll() {
        return pets2;
    }

    @GetMapping(path = "/pets")
    public List<PetDTO> searchByOwner(@RequestParam String owner) {
        List<PetDTO> results = new ArrayList<>();
        for (PetDTO pet : pets2) {
            if (pet.getOwner().equals(owner)) {
                results.add(pet);
            }
        }
        return results;
    }


}

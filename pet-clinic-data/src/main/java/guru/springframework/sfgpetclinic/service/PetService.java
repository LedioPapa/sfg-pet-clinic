package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * Created by ledio on 5/7/19
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

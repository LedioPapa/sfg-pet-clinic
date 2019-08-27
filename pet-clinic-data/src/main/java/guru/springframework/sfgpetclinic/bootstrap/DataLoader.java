package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Ledio Papa on 6/4/19
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final PetService petService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, PetService petService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.petService = petService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

//        int countPetTypes = petTypeService.findAll().size();
//        int countSpecialities = specialityService.findAll().size();
//        int countOwners = ownerService.findAll().size();
        int countVets = vetService.findAll().size();
//        int countPets = petService.findAll().size();

        if (countVets == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        cat = petTypeService.save(cat);

        System.out.println("Loaded Pet Types......!");

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        radiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        surgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        dentistry = specialityService.save(dentistry);

        System.out.println("Loaded Specialities......!");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("address 1");
        owner1.setCity("city 1");
        owner1.setTelephone("123");

        Pet pet1 = new Pet();
        pet1.setName("pet 1");
        pet1.setPetType(dog);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("address 2");
        owner2.setCity("city 2");
        owner2.setTelephone("1234");

        Pet pet2 = new Pet();
        pet2.setName("pet 2");
        pet2.setPetType(cat);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Fiona1");
        owner3.setLastName("Glenanne");
        owner3.setAddress("address 3");
        owner3.setCity("city 3");
        owner3.setTelephone("12345");

        Pet pet3 = new Pet();
        pet3.setName("pet 3");
        pet3.setPetType(dog);
        pet3.setBirthDate(LocalDate.now());
        pet3.setOwner(owner3);
        owner3.getPets().add(pet3);
        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Fiona2");
        owner4.setLastName("Glenanne");
        owner4.setAddress("address 4");
        owner4.setCity("city 4");
        owner4.setTelephone("123456");

        Pet pet4 = new Pet();
        pet4.setName("pet 4");
        pet4.setPetType(cat);
        pet4.setBirthDate(LocalDate.now());
        pet4.setOwner(owner4);
        owner4.getPets().add(pet4);
        ownerService.save(owner4);

        System.out.println("Loaded Owners......!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jessie1");
        vet3.setLastName("Porter1");
        vet3.getSpecialities().add(dentistry);
        vetService.save(vet3);

        Vet vet4 = new Vet();
        vet4.setFirstName("Jessie2");
        vet4.setLastName("Porter2");
        vet4.getSpecialities().add(radiology);
        vetService.save(vet4);

        System.out.println("Loaded Vets......!");

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sick cat");
        visit1.setPet(pet4);
        visitService.save(visit1);

        System.out.println("Loaded Visits......!");
    }
}

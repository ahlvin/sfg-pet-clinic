package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityServices;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityServices specialityServices;
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityServices specialityServices) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityServices = specialityServices;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0 ) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadioLogy = specialityServices.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("surgery");
        Speciality savedSurgery = specialityServices.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("dentistry");
        Speciality savedDentistry = specialityServices.save(dentistry);

        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("some address");
        owner1.setCity("Miami");
        owner1.setTelephone("999999");

        Pet mikePet = new Pet();
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(owner1);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Rosco");
        owner1.getPets().add(mikePet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(1L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("some address");
        owner2.setCity("Miami");
        owner2.setTelephone("999999");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe1");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedRadioLogy);

        Vet vet2 = new Vet();
//        vet2.setId(1L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe2");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}

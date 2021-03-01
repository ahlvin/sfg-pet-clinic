package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by vineet on Feb, 2021
 */
class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final long ownerId =1L;
    final String lastName = "Smith";
    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet= ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner= ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner saveOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(lastName, smith.getLastName());
    }
}
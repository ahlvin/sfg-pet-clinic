package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vineet on Jan, 2021
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}

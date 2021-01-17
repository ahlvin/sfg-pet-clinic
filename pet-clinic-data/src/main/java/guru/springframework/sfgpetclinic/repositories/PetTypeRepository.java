package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vineet on Jan, 2021
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

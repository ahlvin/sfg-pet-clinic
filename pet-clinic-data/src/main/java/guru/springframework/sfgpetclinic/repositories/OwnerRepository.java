package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vineet on Jan, 2021
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);

}

package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vineet on Jan, 2021
 */
public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}

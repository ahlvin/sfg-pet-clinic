package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vineet on Jan, 2021
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}

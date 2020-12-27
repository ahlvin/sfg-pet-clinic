package guru.springframework.sfgpetclinic.services;


import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    Pet save(T object);
    void delete(T object);
    void deleteById(ID id);


}

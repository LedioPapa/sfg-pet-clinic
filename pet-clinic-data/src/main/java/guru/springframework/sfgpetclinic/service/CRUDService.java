package guru.springframework.sfgpetclinic.service;

import java.util.Set;

/**
 * Created by ledio on 5/8/19
 */
public interface CRUDService<T, ID> {

    T findById(ID id);

    T save(T object);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}

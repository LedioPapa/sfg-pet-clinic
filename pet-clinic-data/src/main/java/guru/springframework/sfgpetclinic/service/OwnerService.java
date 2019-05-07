package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;

/**
 * Created by ledio on 5/7/19
 */
public interface OwnerService extends CRUDService<Owner, Long> {

    Owner findByLastName(String lastName);
}

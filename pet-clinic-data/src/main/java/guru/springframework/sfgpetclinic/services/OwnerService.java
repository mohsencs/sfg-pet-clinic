package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findeByLastName(String lastName);

    Owner findeById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}

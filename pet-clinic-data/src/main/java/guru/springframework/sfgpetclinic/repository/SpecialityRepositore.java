package guru.springframework.sfgpetclinic.repository;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepositore extends CrudRepository<Speciality, Long> {
}

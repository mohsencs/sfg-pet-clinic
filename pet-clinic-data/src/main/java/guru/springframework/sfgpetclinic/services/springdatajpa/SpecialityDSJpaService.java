package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repository.SpecialityRepositore;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialityDSJpaService implements SpecialityService {
    private final SpecialityRepositore specialityRepositore;

    public SpecialityDSJpaService(SpecialityRepositore specialityRepositore) {
        this.specialityRepositore = specialityRepositore;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepositore.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepositore.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepositore.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepositore.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepositore.deleteById(aLong);
    }
}

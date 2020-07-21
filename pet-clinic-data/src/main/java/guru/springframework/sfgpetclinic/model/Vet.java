package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
    private Set<Speciality> spiSpecialities = new HashSet<>();

    public Set<Speciality> getSpiSpecialities() {
        return spiSpecialities;
    }

    public void setSpiSpecialities(Set<Speciality> spiSpecialities) {
        this.spiSpecialities = spiSpecialities;
    }
}

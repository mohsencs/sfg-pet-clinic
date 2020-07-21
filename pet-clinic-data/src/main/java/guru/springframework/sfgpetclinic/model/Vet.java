package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {
    private Set<Speciality> spiSpecialities;

    public Set<Speciality> getSpiSpecialities() {
        return spiSpecialities;
    }

    public void setSpiSpecialities(Set<Speciality> spiSpecialities) {
        this.spiSpecialities = spiSpecialities;
    }
}

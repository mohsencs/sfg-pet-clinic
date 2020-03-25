package guru.springframework.sfgpetclinic.model;

import sun.util.resources.LocaleData;

public class Pet {
    private PetType petType;
    private Owner owner;
    private LocaleData birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocaleData getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocaleData birthDate) {
        this.birthDate = birthDate;
    }
}

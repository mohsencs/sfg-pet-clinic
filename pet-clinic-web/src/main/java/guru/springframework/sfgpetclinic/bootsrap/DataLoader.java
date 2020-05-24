package guru.springframework.sfgpetclinic.bootsrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Ali");
        owner1.setLastName("AliOllah");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Hosein");
        owner2.setLastName("Hoseini");
        owner2.setId(2L);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mohammad");
        vet1.setLastName("Mohammadi");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Hashem");
        vet2.setLastName("Hashemi");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}

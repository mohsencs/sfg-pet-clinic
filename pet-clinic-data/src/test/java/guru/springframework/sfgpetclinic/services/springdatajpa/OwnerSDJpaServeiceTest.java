package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repository.OwnerRepository;
import guru.springframework.sfgpetclinic.repository.PetRepository;
import guru.springframework.sfgpetclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServeiceTest {

    public static final String LAST_NAME = "soodkhah";
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaServeice service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findeByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner soodkhah = service.findeByLastName(LAST_NAME);

        verify(ownerRepository, times(1)).findByLastName(any());
        assertEquals(LAST_NAME, soodkhah.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().id(1l).build());
        returnedOwnerSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);

        Set<Owner> owners = service.findAll();

        verify(ownerRepository, times(1)).findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1l);

        assertNotNull(owner);
        assertEquals(1l, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(2l);

        assertNull(owner);
//        assertEquals(1l, owner.getId());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1l).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner ownerSaved = service.save(ownerToSave);
        assertNotNull(ownerSaved);

        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
         service.delete(returnOwner);
         verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}
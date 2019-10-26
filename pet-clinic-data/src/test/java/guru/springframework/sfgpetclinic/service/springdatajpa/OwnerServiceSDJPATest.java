package guru.springframework.sfgpetclinic.service.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by ledio on 9/27/19
 */
@ExtendWith(MockitoExtension.class)
class OwnerServiceSDJPATest {

    public static final String TST = "tst";
    public static final Long TEST_ID1 = 1L;
    public static final Long TEST_ID2 = 2L;
    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerServiceSDJPA service;
    private Owner returnOwner;
    private Owner ownerToSave;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(TEST_ID1).lastName(TST).build();
        ownerToSave = Owner.builder().id(TEST_ID2).lastName(TST).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner tst = service.findByLastName(TST);

        assertEquals(TST, tst.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(returnOwner));
        Owner tst = service.findById(TEST_ID1);

        assertEquals(TEST_ID1, tst.getId());

        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(ownerToSave);
        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
        assertEquals(TEST_ID2, savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(returnOwner);
        owners.add(ownerToSave);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> foundOwners = service.findAll();

        assertNotNull(foundOwners);
        assertEquals(2, foundOwners.size());

    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //checks that the method delete is invoked once
        //if verify is called without the times() parameter, times() defaults to 1
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(TEST_ID1);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findAllByLastNameLikeWithEmptyString() {
        String emptyString = "";
        Set<Owner> allOwners = new HashSet<>(Arrays.asList(ownerToSave, returnOwner, Owner.builder().build()));
        when(ownerRepository.findAllByLastNameLike("%%")).thenReturn(allOwners);

        Set<Owner> returnedOwners = service.findAllByLastNameLike(emptyString);

        assertNotNull(returnedOwners);
        assertEquals(3, returnedOwners.size());

    }
}
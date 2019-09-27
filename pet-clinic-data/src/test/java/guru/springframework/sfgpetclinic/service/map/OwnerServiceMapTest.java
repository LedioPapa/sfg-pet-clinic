package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ledio on 9/10/19
 */
class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    Long id = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(id).build());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(id);
        assertEquals(id, owner.getId());
    }

    @Test
    void save() {
        Owner owner = ownerServiceMap.save(Owner.builder().id(2L).city("test").build());
        assertEquals(Long.valueOf(2L), owner.getId());
        assertEquals("test", owner.getCity());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        Owner owner = ownerServiceMap.save(Owner.builder().id(2L).city("test").build());
        Owner owner1 = ownerServiceMap.save(Owner.builder().id(3L).city("test1").build());
        ownerServiceMap.deleteById(1L);
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        Owner owner = ownerServiceMap.save(Owner.builder().id(2L).city("test").build());
        Owner owner1 = ownerServiceMap.save(Owner.builder().id(3L).city("test1").build());
        ownerServiceMap.delete(owner);
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(2, owners.size());
        for (Owner o : owners) {
            assertNotEquals(o.getId(), owner.getId());
        }
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.save(Owner.builder().id(2L).city("test").lastName("al").build());
        Owner owner1 = ownerServiceMap.save(Owner.builder().id(3L).city("test1").lastName("al").build());
        Owner owner2 = ownerServiceMap.save(Owner.builder().id(3L).city("test1").lastName("it").build());
        Owner owner3 = ownerServiceMap.findByLastName("al");
        assertEquals("al", owner3.getLastName());

        Owner owner4 = ownerServiceMap.findByLastName("al1");
        assertNull(owner4);
    }
}
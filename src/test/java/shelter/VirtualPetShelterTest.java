package shelter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {
    @Test
    public void shouldAddAPet() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);
        assertEquals(1, shelterTest.numberOfPets());
    }

    @Test
    public void shouldReturnPetName() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);
        assertEquals("felix", virtualPet.getName());
    }

    @Test
    public void shouldRemoveAPet() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("James", "A Great Lizard");
        shelterTest.addPet(pet);
        shelterTest.addPet(virtualPet);
        shelterTest.adoptPet("James");
        assertEquals(1, shelterTest.numberOfPets());
    }

    @Test
    public void shouldReturnNumberOfPets() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPet virtualPet2 = new VirtualPet("john", "A cool lizard");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);
        shelterTest.addPet(virtualPet2);
        assertEquals(2, shelterTest.numberOfPets());
    }

    @Test
    public void shouldFeedAllPetsAndIncreaseHungerLevels() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);
        shelterTest.feedAllPets();
        assertEquals(25, virtualPet.getHunger());
    }

    @Test
    public void shouldWaterAllPetsAndIncreaseThirstLevels() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);
        shelterTest.waterAllPets();
        assertEquals(25, virtualPet.getThirst());
    }

    @Test
    public void shouldPlayWithAPetAndIncreaseBoredomLevel() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);
        shelterTest.playWithPet(virtualPet.getName());
        assertEquals(28, virtualPet.getBoredom());
    }

    @Test
    public void shouldReturnAListOfAllPets() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);

        Collection<VirtualPet> allPets = new ArrayList<>(shelterTest.getAllPets());
        assertEquals(true, allPets.contains(virtualPet));

    }

    @Test
    public void shouldExamineAPetAndIncreaseHungerLevelBy5() {
        VirtualPet virtualPet = new VirtualPet("felix", "A cool cat");
        VirtualPetShelter shelterTest = new VirtualPetShelter();
        shelterTest.addPet(virtualPet);
        shelterTest.examinePet(virtualPet.getName());
        int result = virtualPet.getHunger();
        assertEquals(result, 25);
    }

    @Test
    public void shouldInitializePetDatabaseWith4Pets(){
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet joey = new VirtualPet("Joey", "Looks like hes seen better days", 30, 25, 22);
        VirtualPet johnny = new VirtualPet("Johnny", "is a bit nervous", 20, 18, 30);
        VirtualPet deedee = new VirtualPet("Dee Dee", "probably didnt start with that many legs", 19, 21, 28);
        VirtualPet tommy = new VirtualPet("Tommy", "Smells like a stargazer lily fresh with morning dew", 22, 22, 26);
        shelter.addPet(joey);
        shelter.addPet(johnny);
        shelter.addPet(deedee);
        shelter.addPet(tommy);
        assertEquals(4,shelter.getAllPets().size());
    }
}

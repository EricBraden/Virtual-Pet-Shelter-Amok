package shelter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void shouldCreateAPetWithDefaultLevelsOf20(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat");
        assertEquals(20,virtualPet.getBoredom());
        assertEquals(20,virtualPet.getHunger());
        assertEquals(20,virtualPet.getThirst());
    }

    @Test
    public void shouldCreateAPetWithCustomLevels(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat",5,10,15);
        assertEquals(10,virtualPet.getBoredom());
        assertEquals(5,virtualPet.getHunger());
        assertEquals(15,virtualPet.getThirst());
    }

    @Test
    public void shouldExamineAPetAndIncreaseLevelsBy5(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat",10,10,10);
        virtualPet.examinePet();
        assertEquals(15,virtualPet.getBoredom());
        assertEquals(15,virtualPet.getHunger());
        assertEquals(15,virtualPet.getThirst());
    }

    @Test
    public void shouldFeedPetAndIncreaseHungerBy5(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat");
        virtualPet.feedPets();
        assertEquals(25,virtualPet.getHunger());
    }

    @Test
    public void shouldWaterPetAndIncreaseThirstLevelBy5(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat");
        virtualPet.waterPets();
        assertEquals(25,virtualPet.getThirst());
    }

    @Test
    public void shouldUpdateLevelsAndRemove2FromAllLevels(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat");
        virtualPet.updateLevels();
        Assertions.assertAll(
                () ->assertEquals(18,virtualPet.getThirst()),
                () -> assertEquals(18,virtualPet.getBoredom()),
                ()-> assertEquals(18,virtualPet.getHunger()));
    }

    @Test
    public void shouldReturnNameAndDescription(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat");
        assertEquals("Felix",virtualPet.getName());
        assertEquals("A Cool Cat",virtualPet.getDescription());
    }

    @Test
    public void shouldPlayWithPetAndIncreaseBoredom(){
        VirtualPet virtualPet = new VirtualPet("Felix","A Cool Cat");
        virtualPet.play();
        assertEquals(28,virtualPet.getBoredom());
    }

}
